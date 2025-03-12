import * as React from "react";

import { Button } from "@/common/ui/button";
import { Moon, Sun } from "lucide-react";

import { useTheme } from "@/common/contexts";


function Navbar(): React.ReactElement {
	const {theme, setTheme} = useTheme();
	const handleTheme = () => {
		if (theme === "dark") {
			setTheme("light");
			return;
		}
		setTheme("dark");
	};

	return(
		<React.Fragment>
		<nav className={"w-full py-4"}>
			<div className={"container mx-auto flex justify-end"}>

				<Button onClick={handleTheme}
				        className={"cursor-pointer"}
				        variant={"ghost"}
				        size={"icon"}
				>
					<Sun
						className={"h-[1.2rem] w-[1.2rem] rotate-0 scale-100 transition-all dark:-rotate-90 dark:scale-0"}/>
					<Moon
						className={"absolute h-[1.2rem] w-[1.2rem] rotate-90 scale-0 transition-all dark:rotate-0 dark:scale-100"}/>
				</Button>
			</div>
		</nav>
		</React.Fragment>
	)
}

export {
	Navbar,
}