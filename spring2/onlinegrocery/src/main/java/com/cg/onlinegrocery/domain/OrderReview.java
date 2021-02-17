package com.cg.onlinegrocery.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "Order_Review")
public class OrderReview {

	@Id
	@GeneratedValue
	@Column(name = "Order_id")
	private Integer Order_id;

	@NotNull(message = "Cost should not be null")
	private Double OrderCost;

	@Column(name = "OrderDate")
	private String OrderDate;
	
	
	@Column(name = "OrderAddress")
	private String OrderAddress;
	
	@Column(name = "Coupon")
	private double Coupon;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id")
	private OrderReview order;

	@Valid
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "order_id")
	@Fetch(value=FetchMode.SELECT)
	private List<OrderReview> orders;

	public OrderReview(int Order_id, double OrderCost, String OrderDate, String OrderAddress, double Coupon, List<OrderReview> orders) {
		super();
		this.Order_id = Order_id;
		this.OrderCost = OrderCost;
		this.OrderDate = OrderDate;
		this.OrderAddress = OrderAddress;
		this.Coupon = Coupon;
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

	@Override
	public String toString() {
		return "Order [Order_id=" + Order_id + ", OrderCost=" + OrderCost + ", OrderDate=" + OrderDate
				+ ", OrderAddress=" + OrderAddress + ", Coupon=" + Coupon + "]";
	}

}