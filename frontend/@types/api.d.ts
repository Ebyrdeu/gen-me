interface MutationSettings<Params = void, T = unknown> {
	config?: ApiRequestConfig;
	options?: import("@tanstack/react-query").UseMutationOptions<
		Awaited<ReturnType<T>>,
		any,
		Params,
		any
	>;
}

interface QuerySettings<T = unknown> {
	config?: ApiRequestConfig;
	options?: Omit<
		import("@tanstack/react-query").UseQueryOptions<
			Awaited<ReturnType<T>>,
			any,
			Awaited<ReturnType<T>>,
			any
		>,
		"queryKey"
	>;
}

type ApiRequestConfig = import("axios").AxiosRequestConfig;

interface BaseResponse<T> {
	status: string;
	code: number;
	message: string;
	data: T;
}
