package com.cg.onlinegrocery.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Order class will store all the details of the order
 * 
 * @author RC
 */

@Entity
@Table(name = "customer_orders")
public class Order {

	@Id
	@Column(name = "order_id", unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@NotBlank(message = "Customer Name Required")
	private String custName;
	private Double amount;

	

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "ordereditems", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items = new ArrayList<>();

	@Column(name = "order_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	// constructors

	public Order() {

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param orderId     - gives id of order
	 * @param amount      - gives total amount for all items
	 * @param custName-   gives customer name
	 * @param items-      gives list of items
	 * @param date-       gives order date
	 */

	public Order(int orderId, Double amount, String custName, List<Item> items, Date date) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.custName = custName;
		this.items = items;
		this.date = date;
	}

	// getters and setters

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}