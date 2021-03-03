/**
 * 
 * @author Meenali M. Rane
 * Description: This Class has Review Service Mockito Test Cases
 * 
 */
package com.cg.onlinegrocery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.domain.Review;
import com.cg.onlinegrocery.repository.ReviewRepository;
import com.cg.onlinegrocery.service.ReviewService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReviewServiceTest {

	@Autowired
	 private ReviewService reviewService;
	
	@MockBean
	 private ReviewRepository reviewRepository;
	
	/**
	 * Testing viewAllReviews method
	 */
	@Test
	void viewAllReviewsTest() {
		Product product = new Product();
		product.setProductId(3);
		product.setProductName("top ramen fiery chilli");
		product.setProductAmount(40.0);
		product.setProductDescription("noodles");
		product.setProductAvailability("yes");
		
		Review review1 = new Review(1,8,"Good",product);
		Review review2 = new Review(2,9,"Excellent",product);		
		
		when(reviewRepository.findAll()).thenReturn(Stream.of(review1, review2).collect(Collectors.toList()));
		assertEquals(2, reviewService.viewAllReviews().size());

	}
	
	/**
	 * Testing viewAllReviewsByProduct method
	 */
	@Test
	void viewAllReviewsByProductTest() {
		Product product = new Product();
		product.setProductId(3);
		product.setProductName("top ramen fiery chilli");
		product.setProductAmount(40.0);
		product.setProductDescription("noodles");
		product.setProductAvailability("yes");
		
		Review review1 = new Review(1,8,"Good",product);
		Review review2 = new Review(2,9,"Excellent",product);
		
		int productId = 3;
		when(reviewRepository.findAllByReview_Product_Id(productId)).thenReturn(Stream.of(review1, review2).collect(Collectors.toList()));
		assertEquals(2, reviewService.viewAllReviewsByProduct(productId).size());
	}
	
	/**
	 * Testing saveOrUpdateReview method
	 */
	@Test
	void saveOrUpdateReviewTest() {
		Product product = new Product();
		product.setProductId(3);
		product.setProductName("top ramen fiery chilli");
		product.setProductAmount(40.0);
		product.setProductDescription("noodles");
		product.setProductAvailability("yes");
		
		Review review = new Review();
		review.setReviewId(5);
		review.setRating(8);
		review.setFeedback("Good");
		review.setProduct(product);
		
		when(reviewRepository.save(review)).thenReturn(review);
		assertEquals(review,reviewService.saveOrUpdateReview(review));	
	}

}
