/**
 * 
 * @author Meenali M. Rane
 * Description: This Review Class is a POJO and stores details of Product Review 
 * 
 */
package com.cg.onlinegrocery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int reviewId;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "feedback")
	private String feedback;

	//reviews cannot exist without a product
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn (name = "product_id")
	@Valid
	private Product product;

	//Constructors
	public Review() {
		super();
	}
	public Review(int reviewId, float rating, String feedback, @Valid Product product) {
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
	
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rating=" + rating + ", feedback=" + feedback + "]";
	}
	
}