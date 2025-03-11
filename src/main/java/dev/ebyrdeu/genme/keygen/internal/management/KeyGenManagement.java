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
		return this.randomizerApi.random(
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
		return this.randomizerApi.random(
			"Wep128",
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
		return this.randomizerApi.random(
			"Wep128",
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
		return this.randomizerApi.random(
			"Wep128",
			29,
			false,
			false,
			false,
			false,
			true
		);
	}

	@Override
	public String wpa160() {
		return "";
	}

	@Override
	public String wpa512() {
		return "";
	}
}
