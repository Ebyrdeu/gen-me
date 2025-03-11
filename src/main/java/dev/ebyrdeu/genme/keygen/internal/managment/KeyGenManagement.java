package dev.ebyrdeu.genme.keygen.internal.managment;

import dev.ebyrdeu.genme.keygen.KeyGenApi;
import org.springframework.stereotype.Service;

@Service
class KeyGenManagement implements KeyGenApi {

	@Override
	public String wep64() {
		return "";
	}

	@Override
	public String wep128() {
		return "";
	}

	@Override
	public String wep152() {
		return "";
	}

	@Override
	public String wep512() {
		return "";
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
