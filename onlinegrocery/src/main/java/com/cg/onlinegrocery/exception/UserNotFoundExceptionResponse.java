package com.cg.onlinegrocery.exception;

public class UserNotFoundExceptionResponse {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { 
		this.email = email;
	}

	public UserNotFoundExceptionResponse(String email) {
		super();
		this.email = email;
	}

}
