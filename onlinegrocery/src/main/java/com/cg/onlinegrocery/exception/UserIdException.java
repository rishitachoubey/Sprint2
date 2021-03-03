package com.cg.onlinegrocery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserIdException() {
		super();
	}
	
	public UserIdException(String errMsg) {
		super(errMsg);
	}

}
