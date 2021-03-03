/**
 * @author Meenali M. Rane
 * This Class is for Handling the Review Not Found Exception
 * 
 */
package com.cg.onlinegrocery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReviewNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ReviewNotFoundException() {
	}
	public ReviewNotFoundException(String message) {
		super(message);
	}

}
