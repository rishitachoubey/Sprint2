/**
 * 
 * @author Meenali M. Rane
 * This Class is to Implement Services of Product Review 
 * like view Reviews, add Review, update Review, delete Review
 *
 */
package com.cg.onlinegrocery.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinegrocery.domain.Review;
import com.cg.onlinegrocery.exception.ReviewNotFoundException;
import com.cg.onlinegrocery.repository.ReviewRepository;
import com.cg.onlinegrocery.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;

	//View All Reviews	
	@Override
	public List<Review> viewAllReviews() {
		List<Review> reviewsList = (List<Review>) reviewRepository.findAll();
		if (reviewsList.size() == 0)
			throw new ReviewNotFoundException("No Reviews Found");	
		return reviewsList;
	}
	
	//View All Reviews of A Particular Product
	@Override
	public List<Review> viewAllReviewsByProduct(int product_id) {
		List<Review> reviewsByProduct = reviewRepository.findAllByReview_Product_Id(product_id);
		if (reviewsByProduct.size() == 0)
			throw new ReviewNotFoundException("No Reviews Found for Product with ID " + product_id);	
		return reviewsByProduct;
	}
	
	//Add a Review
	@Override
	public Review saveOrUpdateReview(Review review) {
		return reviewRepository.save(review);
	}
	
	//Update a Review
	@Override
	public Review updateReviewByReviewId(Review review) {
		try {
			Review reviewNew = reviewRepository.findById(review.getReviewId()).orElseThrow();
			reviewNew.setRating(review.getRating());
			reviewNew.setFeedback(review.getFeedback());
			reviewNew.setProduct(review.getProduct());
			return reviewRepository.save(reviewNew);
		}
		catch(Exception e) {
			throw new ReviewNotFoundException("Review doesn't exist");
		}
	}

	//Delete a Review
	@Override
	public void deleteReviewByReviewId(int reviewId) {
		try {
			reviewRepository.deleteById(reviewId);
		}
		catch(Exception e) {
			throw new ReviewNotFoundException("Review with ID " + reviewId + " does not exist");
		}
		
	}

}
