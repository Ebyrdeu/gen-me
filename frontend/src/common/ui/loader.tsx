import * as React from "react";


function Loader(): React.ReactElement {

	return (
		<React.Fragment>
			<div
				className="p-4 absolute z-40 inset-0 flex items-center justify-center">
				<div className="flex items-center justify-center">
					<div
						className="h-10 w-10 animate-spin rounded-full border-4 border-primary-foreground border-t-primary"/>
				</div>
			</div>
		</React.Fragment>
	);
}

export {
	Loader,
};