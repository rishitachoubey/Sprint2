package com.cg.onlinegrocery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Order_Review")
public class Order_Review{


@Id
@GeneratedValue

private Integer order_id;
private String customerName;
private String phoneNumber;
private String address;
private String orderDescription;
private int orderPrice;
private String payment = "Cash On Delivery";
public Order_Review(Integer order_id, String customerName, String phoneNumber, String address, String orderDescription,
		int orderPrice) {
	super();
	this.order_id = order_id;
	this.customerName = customerName;
	this.phoneNumber = phoneNumber;
	this.address = address;
	this.orderDescription = orderDescription;
	this.orderPrice = orderPrice;
	
}

public Order_Review() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getOrder_id() {
	return order_id;
}
public void setOrder_id(Integer order_id) {
	this.order_id = order_id;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getOrderDescription() {
	return orderDescription;
}
public void setOrderDescription(String orderDescription) {
	this.orderDescription = orderDescription;
}
public int getOrderPrice() {
	return orderPrice;
}
public void setOrderPrice(int orderPrice) {
	this.orderPrice = orderPrice;
	
}
@Override
public String toString() {
	return "Order_Review [order_id=" + order_id + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber
			+ ", address=" + address + ", orderDescription=" + orderDescription + ", orderPrice=" + orderPrice + "]";
}

}

