import { typedApi } from "@/common/api/instance";
import { AxiosRequestConfig } from "axios";


type KeyGenResponse = KeyGen;

async function getGeneratedKeys(params?: { config?: AxiosRequestConfig }) {
	return typedApi.get<KeyGenResponse>("/gen", params?.config);
}

export {
	getGeneratedKeys,
	type KeyGenResponse,
};