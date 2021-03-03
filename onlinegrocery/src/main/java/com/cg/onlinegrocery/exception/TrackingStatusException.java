package com.cg.onlinegrocery.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TrackingStatusException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrackingStatusException() {
		super();
	}
	
	public TrackingStatusException(String errMsg) {
		super(errMsg);
	}

}