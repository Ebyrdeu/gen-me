import * as React from "react";
import { type Theme, ThemeContext } from "./theme-context";


interface ThemeProviderProps {
	children: React.ReactNode;
	defaultTheme?: Theme;
	storageKey?: string;
}

function ThemeProvider(
	{
		children,
		defaultTheme = "system",
		storageKey = "theme",
		...props
	}: ThemeProviderProps,
): React.ReactElement {
	const [theme, setTheme] = React.useState<Theme>(
		(): Theme => (localStorage.getItem(storageKey) as Theme) ||
			defaultTheme,
	);

	React.useLayoutEffect(() => {
		const root: HTMLElement = window.document.documentElement;

		root.classList.remove("light", "dark");

		if (theme === "system") {
			const systemTheme: "dark" | "light" = window.matchMedia(
				"(prefers-color-scheme: dark)",
			).matches ? "dark" : "light";

			root.classList.add(systemTheme);
			return;
		}

		root.classList.add(theme);
	}, [theme]);

	const value = {
		theme,
		setTheme: (theme: Theme): void => {
			localStorage.setItem(storageKey, theme);
			setTheme(theme);
		},
	};

	return (
		<ThemeContext.Provider {...props} value={value}>
			{children}
		</ThemeContext.Provider>
	);
}

export {
	ThemeProvider,
	type ThemeProviderProps,
};