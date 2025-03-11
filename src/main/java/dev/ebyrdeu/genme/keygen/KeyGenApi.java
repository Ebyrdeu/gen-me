package dev.ebyrdeu.genme.keygen;

public interface KeyGenApi {
	String wep64();

	String wep128();

	String wep152();

	String wep512();

	String wpa160();

	String wpa512();
}
