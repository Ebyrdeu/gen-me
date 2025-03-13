import { toast } from "sonner";
import { Card, CardContent, CardHeader, CardTitle } from "@/common/ui";
import { GibberishText } from "./gibberish-text-effect";


interface KeyGenCardProps {
	data: string[];
	title: string;
}

function KeyGenCard({data, title}: KeyGenCardProps) {

	const handleCopy = async (text: string) => {
		await navigator.clipboard.writeText(text)
		               .then(() => {
			               toast.success("Copied to clipboard", {
				               description: () => `Key : ${text}`,
				               duration: 1_000,
			               });
		               })
		               .catch((error) => {
			               toast.error("Something went wrong while copied to clipboard", {
				               description: error,
			               });
		               });
	};


	return (
		<Card
			className={"mb-4 rounded-none"}>
			<CardHeader>
				<CardTitle>{title}</CardTitle>
			</CardHeader>
			<CardContent>
				<div className={"grid grid-cols-1 gap-2 md:grid-cols-2 md:gap-4 "}>
					{data.map((text, i) => (
						<div
							className={"cursor-pointer truncate text-center border p-2 hover:bg-slate-100 dark:hover:bg-slate-900 transition-all "}
							key={i}
							onClick={() => handleCopy(text)}>
							<GibberishText className={"text-sm md:text-base "}
							               text={text}/>
						</div>
					))}
				</div>
			</CardContent>
		</Card>
	);
}

export {
	KeyGenCard,
};
