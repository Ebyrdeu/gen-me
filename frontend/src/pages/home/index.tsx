import * as React from "react";
import { Navbar } from "@/widgets";


function Home(): React.ReactElement {
	return (
		<React.Fragment>
			<div className={"w-screen h-screen"}>
				<Navbar/>
			</div>
		</React.Fragment>
	)
}

export {
	Home
}