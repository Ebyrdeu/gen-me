import * as React from "react";

import { QueryClientProvider } from "@tanstack/react-query";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";
import { queryClient } from "./query-client";


interface QueryProviderProps extends React.ComponentProps<typeof QueryClientProvider> {
	children: React.ReactNode;
}

function QueryProvider({children}: Omit<QueryProviderProps, "client">): React.ReactElement {

	return (
		<QueryClientProvider client={queryClient}>
			{children}
			<ReactQueryDevtools  initialIsOpen={false}/>
		</QueryClientProvider>
	);
}

export {
	QueryProvider,
	type QueryProviderProps,
};