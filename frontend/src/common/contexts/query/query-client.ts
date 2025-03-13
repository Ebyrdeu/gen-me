import { MutationCache, QueryCache, QueryClient } from "@tanstack/react-query";
import { toast } from "sonner";
import { AxiosError } from "axios";


const DEFAULT_MESSAGE = "Something went wrong";
const DEFAULT_STATUS = 500;

export const queryClient: QueryClient = new QueryClient({
	defaultOptions: {
		queries: {
			staleTime: 5 * 60 * 1000,
			gcTime: 5 * 60 * 1000,
			refetchOnWindowFocus: false,
		},
	},
	queryCache: new QueryCache({
		onError: (cause) => {
			const {response} = cause as AxiosError<BaseResponse<unknown>>;
			toast.error(response?.data.status ?? DEFAULT_STATUS, {
				description: response?.data.message ?? DEFAULT_MESSAGE,
				action: {
					label: "X",
					onClick: () => {
						return;
					},
				},
			});
		},
	}),
	mutationCache: new MutationCache({
		onError: (cause) => {
			const {response} = cause as AxiosError<BaseResponse<unknown>>;
			toast.error(response?.data.message ?? DEFAULT_MESSAGE, {
				description: response?.data.message ?? DEFAULT_MESSAGE,
				action: {
					label: "X",
					onClick: () => {
						return;
					},
				},
			});
		},
	}),
});
