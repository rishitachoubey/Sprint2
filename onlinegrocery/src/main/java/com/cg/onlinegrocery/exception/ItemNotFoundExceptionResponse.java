package com.cg.onlinegrocery.exception;

public class ItemNotFoundExceptionResponse {
		
		private String itemName;

		public ItemNotFoundExceptionResponse(String itemName) {
			super();
			this.itemName = itemName;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}


	
		
	}

