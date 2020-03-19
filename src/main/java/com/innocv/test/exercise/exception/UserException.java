package com.innocv.test.exercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.innocv.test.exercise.dto.ResponseDto;

@ControllerAdvice
public class UserException {

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ResponseDto> illegalArgumentException(IllegalArgumentException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ResponseDto("BAD_REQUEST", exception.getMessage(), exception));
	}
}
