package com.cg.onlinegrocery.exception;

public class UserIdExceptionResponse {
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { 
		this.email = email;
	}

	public UserIdExceptionResponse(String email) {
		super();
		this.email = email;
	}

}
