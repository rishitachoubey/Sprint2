/**
 * 
 * @author Meenali M. Rane
 * Description: This Review Class is a POJO and stores details of Product Review 
 * 
 */
package com.cg.onlinegrocery.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	private int reviewId;
	private float rating;
	private String feedback;
	@ManyToOne
	@JoinColumn (name = "product_id")
	private Product product;
	
	
	//Constructors - Default and Parameterized
	public Review() {
		super();
	}
	
	public Review(int reviewId, float rating, String feedback, Product product) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.feedback = feedback;
		this.product = product;
	}


	//Getters and Setters
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}