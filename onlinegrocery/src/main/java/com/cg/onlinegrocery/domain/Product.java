/**
 * 
 * @author Meenali M. Rane
 * Description: This Product Class is a POJO and will Store all the Details of the Product 
 * 
 */
package com.cg.onlinegrocery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_amount")
	private double productAmount;
	@Column(name = "product_description")
	private String productDescription;
	private String availability;
	

	
	//Constructor
	public Product() {
		super();
	}
	

	//Getters and setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String description) {
		this.productDescription = description;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
