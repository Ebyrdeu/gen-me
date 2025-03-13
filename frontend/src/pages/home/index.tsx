import * as React from "react";
import { Navbar } from "@/widgets";
import { useGetGeneratedKeysQuery } from "@/common/api/hooks";
import { Button, Loader } from "@/common/ui";
import { RotateCw } from "lucide-react";
import { KeyGenCard } from "@/pages/home/ui";


function Home(): React.ReactElement {
	const {data, isLoading, refetch} = useGetGeneratedKeysQuery();

	if (isLoading) {
		return <Loader/>;
	}

	const {
		wep64,
		wep128,
		wep152,
		wep256,
		wpa160,
		wpa504,
	} = data!.data;

	return (
		<React.Fragment>
			<Navbar/>
			<div className={"container mx-auto"}>
				<div className={"flex justify-center my-20"}>
					<Button
						size={"lg"}
						variant={"default"}
						className={"cursor-pointer"}
						onClick={() => refetch()}>
						<RotateCw/>
						Generate New Set of Keys
					</Button>
				</div>
				<KeyGenCard data={wep64} title={"64-bit WEP Key"}/>
				<KeyGenCard data={wep128} title={"128-bit WEP Key"}/>
				<KeyGenCard data={wep152} title={"152-bit WEP Key"}/>
				<KeyGenCard data={wep256} title={"256-bit WEP Key"}/>
				<KeyGenCard data={wpa160} title={"160-bit WPA Key"}/>
				<KeyGenCard data={wpa504} title={"504-bit WPA Key"}/>
			</div>
		</React.Fragment>
	);
}


export {
	Home,
};