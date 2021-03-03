package com.cg.onlinegrocery.exception;

public class TrackingStatusExceptionResponse {
	
		private String trackingStatus;


		public TrackingStatusExceptionResponse(String orderIdentifier) {
			super();
			this.trackingStatus = orderIdentifier;
		}

		public String getOrderIdentifier() {
			return trackingStatus;
		}

		public void setOrderIdentifier(String orderIdentifier) {
			this.trackingStatus = orderIdentifier;
		}

	}