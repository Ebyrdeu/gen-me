package dev.ebyrdeu.genme.keygen.internal.web;

import dev.ebyrdeu.genme.keygen.KeyGenApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gen")
class KeyGenController {

	private final KeyGenApi keyGenApi;

	public KeyGenController(KeyGenApi keyGenApi) {
		this.keyGenApi = keyGenApi;
	}


	@GetMapping
	public String getWep512() {
		return keyGenApi.wep512();
	}
}
