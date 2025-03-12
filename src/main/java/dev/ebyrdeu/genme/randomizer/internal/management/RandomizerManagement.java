package dev.ebyrdeu.genme.randomizer.internal.management;

import dev.ebyrdeu.genme.randomizer.RandomizerApi;
import dev.ebyrdeu.genme.randomizer.internal.excpetion.RandomizerInternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
class RandomizerManagement implements RandomizerApi {

	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERS = "1234567890";
	private static final String SPECIAL_CHARACTERS = "`~!@#$%^&*()-=_+[]{}|;':\",./<>?";
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
		log.info("[RandomizerManagement/random]:: Execution started.");
		try {

			if (length > 64) {
				throw new IllegalArgumentException("Max length is 64 chars");
			}

			if (!lowerCase && !upperCase && !numbers && !specialCharacters && !hex) {
				throw new IllegalArgumentException("At least one boolean argument need to be true");
			}

			StringBuilder pool = new StringBuilder();
			StringBuilder key = new StringBuilder();
			SecureRandom random = new SecureRandom();

			if (lowerCase) {
				pool.append(LOWER_CASE);
				log.debug("[RandomizerManagement/random] :: LOWER_CASE added to pool for {}", implementation);
			}

			if (upperCase) {
				pool.append(UPPER_CASE);
				log.debug("[RandomizerManagement/random] :: UPPER_CASE added to pool for {}", implementation);
			}

			if (numbers) {
				pool.append(NUMBERS);
				log.debug("[RandomizerManagement/random] :: NUMBERS added to pool for {}", implementation);
			}

			if (specialCharacters) {
				pool.append(SPECIAL_CHARACTERS);
				log.debug("[RandomizerManagement/random] :: SPECIAL_CHARACTERS added to pool for {}", implementation);
			}

			if (hex) {
				pool.append(HEX);
				log.debug("[RandomizerManagement/random] :: HEX added to pool for {}", implementation);
			}

			log.debug("[RandomizerManagement/random] :: current pool before key gen - {}", pool);

			// NOTE: String.repeat() is possible but loops more readable
			for (int i = 0; i < length; i++) {
				int number = random.nextInt(pool.length() - 1);
				key.append(pool.charAt(number));
			}

			return key.toString();
		} catch (RuntimeException e) {
			log.error("[RandomizerManagement/random]:: Exception occurred while generating keys. Exception: {}", e.getMessage());
			throw new RandomizerInternalServerErrorException("Failed to generate keys due to an unexpected error :: " + e.getMessage());
		} finally {
			log.info("[RandomizerManagement/random]:: Execution ended.");
		}
	}
}