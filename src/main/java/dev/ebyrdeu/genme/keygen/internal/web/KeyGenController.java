package dev.ebyrdeu.genme.keygen.internal.web;

import dev.ebyrdeu.genme.keygen.KeyGenApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/api/v1/gen")
class KeyGenController {

	private final KeyGenApi keyGenApi;

	public KeyGenController(KeyGenApi keyGenApi) {
		this.keyGenApi = keyGenApi;
	}

	@GetMapping
	public WepWpaData getAll() {
		String wep64 = this.keyGenApi.wep64();
		String wep128 = this.keyGenApi.wep128();
		String wep152 = this.keyGenApi.wep152();
		String wep256 = this.keyGenApi.wep256();
		String wpa160 = this.keyGenApi.wpa160();
		String wpa512 = this.keyGenApi.wpa512();

		return new WepWpaData(
			wep64,
			wep128,
			wep152,
			wep256,
			wpa160,
			wpa512
		);
	}

	record WepWpaData(
		String wep64,
		String wep128,
		String wep152,
		String wep256,
		String wpa160,
		String wpa512
	) implements Serializable {

	}
}
