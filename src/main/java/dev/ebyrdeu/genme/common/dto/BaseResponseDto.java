package dev.ebyrdeu.genme.common.dto;


import org.springframework.http.HttpStatus;


/**
 * @author Maxim Khnykin
 * @version 1.0
 * */
public record BaseResponseDto<T>(
	HttpStatus status,
	int code,
	String message,
	T data
) implements java.io.Serializable {
}
