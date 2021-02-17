package com.cg.onlinegrocery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

/**
 * This class is a pojo for item
 * 
 * @author RC
 *
 */

@Entity
public class Item {
	@Column(name = "item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank(message = "Item ID Required")
	private int itemId;
	@NotBlank(message = "Item Name Required")
	private String itemName;
	@NotBlank(message = "Item Price Required")
	private double itemPrice;
	@NotBlank(message = "Item Quantity Required")
	private int itemQuantity;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderId;

	public Item() {

	}

	public Item(Order order) {
		this.orderId = order;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param itemId-       gives id of item
	 * @param itemName-     gives item name
	 * @param itemPrice-    gives item price
	 * @param itemQuantity- gives item quantity
	 * @param orderId-      gives order id
	 */

	public Item(int itemId, String itemName, double itemPrice, int itemQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		
	}

	// getters and setters

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



}
