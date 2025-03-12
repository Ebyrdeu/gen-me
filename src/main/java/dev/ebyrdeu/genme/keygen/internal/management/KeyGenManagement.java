package dev.ebyrdeu.genme.keygen.internal.management;

import dev.ebyrdeu.genme.keygen.KeyGenApi;
import dev.ebyrdeu.genme.randomizer.RandomizerApi;
import org.springframework.stereotype.Service;


@Service
class KeyGenManagement implements KeyGenApi {
	private final RandomizerApi randomizerApi;

	public KeyGenManagement(RandomizerApi randomizerApi) {
		this.randomizerApi = randomizerApi;
	}

	@Override
	public String wep64() {
		return this.randomizerApi.custom(
			"Wep64",
			5,
			false,
			false,
			false,
			false,
			true
		);
	}

	@Override
	public String wep128() {
		return this.randomizerApi.custom(
			"WEP128",
			13,
			false,
			false,
			false,
			false,
			true
		);
	}

	@Override
	public String wep152() {
		return this.randomizerApi.custom(
			"WEP128",
			16,
			false,
			false,
			false,
			false,
			true
		);
	}

	@Override
	public String wep256() {
		return this.randomizerApi.custom(
			"WEP128",
			32,
			false,
			false,
			false,
			false,
			true
		);
	}

	@Override
	public String wpa160() {
		return this.randomizerApi.custom(
			"WPA160",
			20,
			true,
			true,
			true,
			true,
			false
		);
	}

	@Override
	public String wpa504() {
		return this.randomizerApi.custom(
			"WPA504",
			63,
			true,
			true,
			true,
			true,
			false
		);
	}
}
