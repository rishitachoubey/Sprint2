package com.cg.onlinegrocery.exception;

public class TrackingStatusNotFoundExceptionResponse {
	
	private String trackingStatusNotFound;

	public TrackingStatusNotFoundExceptionResponse(String orderNotFound) {
		super();
		this.trackingStatusNotFound = orderNotFound;
	}

	public String getProjectNotFound() {
		return trackingStatusNotFound;
	}

	public void setProjectNotFound(String projectNotFound) {
		this.trackingStatusNotFound = projectNotFound;
	}
	
}