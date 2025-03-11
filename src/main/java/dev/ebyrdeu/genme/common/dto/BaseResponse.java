package dev.ebyrdeu.genme.common.dto;


import org.springframework.http.HttpStatus;


/**
 * @author Maxim Khnykin
 * @version 1.0
 * */
public record BaseResponse<T>(
	HttpStatus httpStatus,
	int code,
	T data
) implements java.io.Serializable {
}
