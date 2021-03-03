/**
 * 
 * @author Meenali M. Rane
 * Description: RestController Mapping Request Data to the defined Request Handler Method
 * 
 */
package com.cg.onlinegrocery.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinegrocery.domain.Review;
import com.cg.onlinegrocery.service.MapValidationErrorService;
import com.cg.onlinegrocery.service.ReviewService;

@RestController
@RequestMapping("/api/products")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/reviews/all")
	public ResponseEntity<List<Review>> viewAll() {
		List<Review> reviewsByProduct = reviewService.viewAllReviews();
		return new ResponseEntity<List<Review>>(reviewsByProduct, HttpStatus.OK);
	}
	
	@GetMapping("/reviews/{product_id}")
	public ResponseEntity<List<Review>> viewAllByProductId(@PathVariable int product_id) {
		List<Review> reviewsByProduct = reviewService.viewAllReviewsByProduct(product_id);
		return new ResponseEntity<List<Review>>(reviewsByProduct, HttpStatus.OK);
	}
	
	@PostMapping("/reviews/add")
	public ResponseEntity<?> addReview(@Valid @RequestBody Review review, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Review reviewAdded = reviewService.saveOrUpdateReview(review);
		return new ResponseEntity<Review>(reviewAdded, HttpStatus.OK);
	}
	
	@PutMapping("/reviews/{reviewId}/update")
	public ResponseEntity<?> updateReview(@Valid @RequestBody Review review, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Review reviewAdded = reviewService.updateReviewByReviewId(review);
		return new ResponseEntity<Review>(reviewAdded, HttpStatus.OK);
	}

	@DeleteMapping("/reviews/{reviewId}/delete")
	public ResponseEntity<?> deleteReview(@PathVariable int reviewId) {
		reviewService.deleteReviewByReviewId(reviewId);
		String message = "Review with ID " + reviewId + " has been Deleted!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}