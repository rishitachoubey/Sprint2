package com.cg.onlinegrocery.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemNotFoundException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException() {
		super();
	}
	
	public ItemNotFoundException(String errMsg) {
		super(errMsg);
	}
}
