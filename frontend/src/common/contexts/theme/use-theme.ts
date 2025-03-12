import * as React from "react";
import { ThemeContext, type ThemeContextProps } from "./theme-context";


export function useTheme(): ThemeContextProps {
	const context: ThemeContextProps = React.useContext(ThemeContext);

	if (context === undefined) {
		throw new Error(
			"[hooks/useTheme]:: must be used within a ThemeProvider",
		);
	}

	return context;
}
