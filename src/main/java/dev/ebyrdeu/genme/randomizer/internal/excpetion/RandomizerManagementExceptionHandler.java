package dev.ebyrdeu.genme.randomizer.internal.excpetion;

import dev.ebyrdeu.genme.common.dto.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Maxim Khnykin
 * @version 1.0
 */
@RestControllerAdvice
class RandomizerManagementExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RandomizerInternalServerErrorException.class)
	public BaseResponseDto<?> handleUserServiceException(RandomizerInternalServerErrorException exception) {
		return new BaseResponseDto<>(
			HttpStatus.INTERNAL_SERVER_ERROR,
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			exception.getMessage(),
			null
		);
	}
}
