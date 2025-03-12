package dev.ebyrdeu.genme.randomizer;



public interface RandomizerApi {

	String custom(
		String implementation,
		int length,
		boolean lowerCase,
		boolean upperCase,
		boolean numbers,
		boolean specialCharacters,
		boolean hex
	);

}
