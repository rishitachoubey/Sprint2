package com.cg.onlinegrocery.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Order class will store all the details of the order
 * 
 * @author RC
 */

//This table should have one to one mapping with customer

@Entity
@Table(name = "customer_orders")
public class Order {

	@Id
	@Column(name = "order_id", unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private String custName;
	
	private Double amount;
	
	@Column(updatable = false)
	private String orderIdentifier;
	

	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "order")
	private List<Item> items = new ArrayList<>();

	@Column(name = "order_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	// constructors

	public Order() {
		super();

	}



	// getters and setters

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOrderIdentifier() {
		return orderIdentifier;
	}

	public void setOrderIdentifier(String orderIdentifier) {
		this.orderIdentifier = orderIdentifier;
	}
	public List<Item> getItems() {
		return items;
	}

	

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@PrePersist	
	public void onCreate() {
		
		this.createdAt= new Date();
	}
	
}
