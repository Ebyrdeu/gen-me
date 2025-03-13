import * as React from "react";
import { QueryProvider, ThemeProvider } from "@/common/contexts";
import { Toaster } from "@/common/ui";


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
					<Toaster duration={TOASTER_DURATION}/>
				</ThemeProvider>
			</QueryProvider>
		</React.Fragment>
	);
}

export {
	Providers,
};
