package com.cg.onlinegrocery.exception;

public class OrderNotFoundExceptionResponse {
		
		private String orderNotFound;

		public OrderNotFoundExceptionResponse(String orderNotFound) {
			super();
			this.orderNotFound = orderNotFound;
		}

		public String getOrderNotFound() {
			return orderNotFound;
		}

		public void setOrderNotFound(String projectNotFound) {
			this.orderNotFound = projectNotFound;
		}
		
	}

