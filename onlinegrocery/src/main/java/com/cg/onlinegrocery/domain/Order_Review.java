package com.cg.onlinegrocery.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Order_Review")
public class Order_Review {

	@Id
	@NotNull(message= "Order id should not be null")
	private int Order_id;

	@NotNull(message = "Cost should not be null")
	private Double OrderCost;

	@Column(name = "OrderDate")
	private String OrderDate;
	
	@Column(name = "OrderAddress")
	private String OrderAddress;
	
	@Column(name = "Coupon")
	private int Coupon;

//
//	@Valid
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "order_id")
//	@Fetch(value=FetchMode.SELECT)
//	private List<Order> orders;

	public Order_Review(int Order_id, double OrderCost, String OrderDate, String OrderAddress, int Coupon, List<Order_Review> orders) {
		super();
		this.Order_id = Order_id;
		this.OrderCost = OrderCost;
		this.OrderDate = OrderDate;
		this.OrderAddress = OrderAddress;
		this.Coupon = Coupon;
	}
	
   
	public Order_Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setOrder_id(int Order_id) {
		this.Order_id = Order_id;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrderCost(double OrderCost) {
		this.OrderCost = OrderCost;
	}
	public double getOrderCost() {
		return OrderCost;
	}
	public void setOrderDate(String OrderDate) {
		this.OrderDate = OrderDate;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderAddress(String OrderAddress) {
		this.OrderAddress = OrderAddress;
	}
	public String getOrderAddress() {
		return OrderAddress;
	}
	public double getCoupon() {
		return Coupon;
	}
	public void setCoupon(int Coupon) {
		this.Coupon = Coupon;
	}

	@Override
	public String toString() {
		return "Order [Order_id=" + Order_id + ", OrderCost=" + OrderCost + ", OrderDate=" + OrderDate
				+ ", OrderAddress=" + OrderAddress + ", Coupon=" + Coupon + "]";
	}
	




}

