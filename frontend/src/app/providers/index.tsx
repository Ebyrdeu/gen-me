import * as React from "react";
import { QueryProvider, ThemeProvider } from "@/common/contexts";
import { Toaster } from "@/common/ui/sonner.tsx";


interface ProvidersProps {
	children: React.ReactNode;
}

const TOASTER_DURATION = 5_000;

function Providers({children}: ProvidersProps): React.ReactElement {
	return (
		<React.Fragment>
			<QueryProvider>
				<ThemeProvider>
					{children}
				</ThemeProvider>
			</QueryProvider>
			<Toaster duration={TOASTER_DURATION}/>
		</React.Fragment>
	);
}

export {
	Providers,
};
