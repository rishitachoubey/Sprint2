package com.cg.onlinegrocery.exception;

public class OrderIdExceptionResponse {
	private String orderIdentifier;


	public OrderIdExceptionResponse(String orderIdentifier) {
		super();
		this.orderIdentifier = orderIdentifier;
	}

	public String getOrderIdentifier() {
		return orderIdentifier;
	}

	public void setOrderIdentifier(String orderIdentifier) {
		this.orderIdentifier = orderIdentifier;
	}

}

