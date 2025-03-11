package dev.ebyrdeu.genme.keygen.internal.web;

import dev.ebyrdeu.genme.keygen.KeyGenApi;
import dev.ebyrdeu.genme.keygen.internal.dto.KeyGenResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;


@RestController
@RequestMapping("/api/v1/gen")
class KeyGenController {
	private final KeyGenApi keyGenApi;

	public KeyGenController(KeyGenApi keyGenApi) {
		this.keyGenApi = keyGenApi;
	}

	@GetMapping
	public KeyGenResponseDto getAll(@RequestParam(defaultValue = "6", required = false) int count) {
		List<String> wep64 = IntStream.range(0, count)
			.mapToObj(_ -> this.keyGenApi.wep64())
			.toList();

		List<String> wep128 = IntStream.range(0, count)
			.mapToObj(_ -> this.keyGenApi.wep128())
			.toList();

		List<String> wep152 = IntStream.range(0, count)
			.mapToObj(_ -> this.keyGenApi.wep152())
			.toList();

		List<String> wep256 = IntStream.range(0, count)
			.mapToObj(_ -> this.keyGenApi.wep256())
			.toList();

		List<String> wpa160 = IntStream.range(0, count)
			.mapToObj(_ -> this.keyGenApi.wpa160())
			.toList();

		List<String> wpa504 = IntStream.range(0, count)
			.mapToObj(_ -> this.keyGenApi.wpa504())
			.toList();

		return new KeyGenResponseDto(
			wep64,
			wep128,
			wep152,
			wep256,
			wpa160,
			wpa504
		);
	}

}
