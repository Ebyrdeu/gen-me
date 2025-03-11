package dev.ebyrdeu.genme.common.dto;


public record BaseResponse<T>(
	T data
) implements java.io.Serializable {
}
