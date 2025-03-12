import * as React from "react";


type Theme = "dark" | "light" | "system"

interface ThemeContextProps {
	theme: Theme;
	setTheme: (theme: Theme) => void;
}

const ThemeContext = React.createContext<ThemeContextProps>({
	theme: "system",
	setTheme: () => null,
});

export {
	ThemeContext,
	type ThemeContextProps,
	type Theme,
};
