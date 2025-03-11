package dev.ebyrdeu.genme.keygen.internal.dto;

import java.util.List;


public record KeyGenResponseDto(
List<String> wep64,
List<String> wep128,
List<String> wep152,
List<String> wep256,
List<String> wpa160,
List<String> wpa504
) implements java.io.Serializable {
}
