import * as React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";

import { Providers } from "./providers";
import { Home } from "@/pages/home";


const rootElement = document.getElementById("root")!;

if (!rootElement.innerHTML) {
	const root = ReactDOM.createRoot(rootElement);
	root.render(
		<React.StrictMode>
			<Providers>
				<Home/>
			</Providers>
		</React.StrictMode>,
	);
}
