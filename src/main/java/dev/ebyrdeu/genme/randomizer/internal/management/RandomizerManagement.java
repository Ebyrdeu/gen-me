package dev.ebyrdeu.genme.randomizer.internal.management;

import dev.ebyrdeu.genme.randomizer.RandomizerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class RandomizerManagement implements RandomizerApi {
	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERS = "1234567890";
	private static final String SPECIAL_CHARACTERS = "`~!@#$%^&*()-=_+[]{}|;':\",./<>?\\";
	private static final String HEX = "123456789ABCDEF";
	private static final Logger log = LoggerFactory.getLogger(RandomizerManagement.class);

	@Override
	public String random(
		String implementation,
		int length,
		boolean lowerCase,
		boolean upperCase,
		boolean numbers,
		boolean specialCharacters,
		boolean hex
	) {
		StringBuilder pool = new StringBuilder();
		StringBuilder key = new StringBuilder();

		if (lowerCase) {
			pool.append(LOWER_CASE);
			log.info("[RandomizerManagement/random] :: LOWER_CASE added to pool for {}", implementation);
		}

		if (upperCase) {
			pool.append(UPPER_CASE);
			log.info("[RandomizerManagement/random] :: UPPER_CASE added to pool for {}", implementation);
		}

		if (numbers) {
			pool.append(NUMBERS);
			log.info("[RandomizerManagement/random] :: NUMBERS added to pool for {}", implementation);
		}

		if (specialCharacters) {
			pool.append(SPECIAL_CHARACTERS);
			log.info("[RandomizerManagement/random] :: SPECIAL_CHARACTERS added to pool for {}", implementation);
		}

		if (hex) {
			pool.append(HEX);
			log.info("[RandomizerManagement/random] :: HEX added to pool for {}", implementation);
		}

		for (int i = 0; i < length; i++) {
			int rounded = (int) Math.floor(Math.random() * (pool.capacity() - 1));
			log.info("rounded value :::::::: {}", rounded);
			key.append(pool.charAt(rounded));
		}

		return key.toString();
	}
}