/**
 * 
 * @author Meenali M. Rane
 * Description: This Product Class is a POJO and will Store all the Details of the Product 
 * 
 */
package com.cg.onlinegrocery.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_amount")
	private double productAmount;
	@Column(name = "product_description")
	private String productDescription;
	private String availability;
	
	@OneToMany (mappedBy = "product")
	@OneToMany (mappedBy = "order")
	private List<Review> reviews = new ArrayList<>();

	
	//Constructors - Default and Parameterized	
	public Product() {
		super();
	}
	 
	public Product(int productId, String productName, double productAmount, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.productDescription = productDescription;
	}


	//Generate Getters and setters
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
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
