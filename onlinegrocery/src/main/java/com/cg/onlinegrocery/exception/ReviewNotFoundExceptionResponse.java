/**
 * @author Meenali M. Rane
 * This Class is for Handling the Response of Review Not Found Exception
 * 
 */
package com.cg.onlinegrocery.exception;

public class ReviewNotFoundExceptionResponse {

	private String reviewNotFound;
	
	public ReviewNotFoundExceptionResponse(String reviewNotFound) {
		super();
		this.reviewNotFound = reviewNotFound;
	}
	
	public String getProjectNotFound() {
		return reviewNotFound;
	}

	public void setProductNotFound(String reviewNotFound) {
		this.reviewNotFound = reviewNotFound;
	}

}
