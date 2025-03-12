import axios, { type AxiosInstance, type AxiosRequestConfig } from "axios";


type Response<T> = BaseResponse<T>;

type CustomAxiosInstance =
	Omit<AxiosInstance, "get" | "post" | "put" | "patch" | "delete">
	& {
	get<T = any, R = Response<T>, D = any>(
		url: string, config?: AxiosRequestConfig<D>): Promise<R>;
	post<T = any, R = Response<T>, D = any>(
		url: string, data?: D, config?: AxiosRequestConfig<D>): Promise<R>;
	put<T = any, R = Response<T>, D = any>(
		url: string, data?: D, config?: AxiosRequestConfig<D>): Promise<R>;
	patch<T = any, R = Response<T>, D = any>(
		url: string, data?: D, config?: AxiosRequestConfig<D>): Promise<R>;
	delete<T = any, R = Response<T>, D = any>(
		url: string, config?: AxiosRequestConfig<D>): Promise<R>;
};

const api: CustomAxiosInstance = axios.create({
	baseURL: "/api/v1",
	withCredentials: true,
	withXSRFToken: true,
});

api.interceptors.response.use(
	response => response.data,
	error => Promise.reject(error),
);


export const typedApi = api as CustomAxiosInstance;