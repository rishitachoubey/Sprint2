/**
 * 
 * @author Meenali M. Rane
 * This Interface is to Declare Services of Product Review 
 * like view Reviews, add Review, update Review, delete Review
 *
 */
package com.cg.onlinegrocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlinegrocery.domain.Review;

@Service
public interface ReviewService {
	
	/**
	 * This method returns the list of all reviews
	 * @param productId
	 */
	public List<Review> viewAllReviews();
	/**
	 * This method returns the list of reviews for a particular product
	 * @param productId
	 */
	public List<Review> viewAllReviewsByProduct(int productId);
	/**
	 * This method adds a review
	 * @param review
	 */
	public Review saveOrUpdateReview(Review review);
	/**
	 * This method updates a review
	 * @param review
	 * @param reviewId
	 */
	public Review updateReviewByReviewId(Review review);
	/**
	 * This method deletes a review
	 * @param reviewId
	 */
	public void deleteReviewByReviewId(int reviewId);

	
	
}
