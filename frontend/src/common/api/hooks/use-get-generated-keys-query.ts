import { useQuery } from "@tanstack/react-query";
import { getGeneratedKeys } from "@/common/api/keygen";


export const useGetGeneratedKeysQuery = (
	settings?: QuerySettings<typeof getGeneratedKeys>,
) => useQuery({
	queryKey: ["generated-keys"],
	queryFn: () => getGeneratedKeys({config: settings?.config}),
	retry: false,
	...settings?.options,
});

