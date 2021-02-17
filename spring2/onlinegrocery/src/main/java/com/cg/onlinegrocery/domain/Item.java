package com.cg.onlinegrocery.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private int itemId;
	@NotBlank(message = "Item Name Required")
	private String itemName;
	@NotBlank(message = "Item Price Required")
	private double itemPrice;
	@NotBlank(message = "Item Quantity Required")
	private int itemQuantity;
	@Column(updatable = false)
	private String itemIdentifier;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "order_id",updatable = false, nullable = false)
	@JsonIgnore
	private Order order;
	
	@Column(updatable = false)
	private String orderIdentifier;

	public Item() {
		super();
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

	public String getOrderIdentifier() {
		return orderIdentifier;
	}

	public void setOrderIdentifier(String orderIdentifier) {
		this.orderIdentifier = orderIdentifier;
	}


	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}


}
