package com.cg.onlinegrocery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
	
	@Test
	public void saveOrUpdateReviewTest() {
		Product product = new Product();
		product.setProductId(3);
		product.setProductName("top ramen fiery chilli");
		product.setProductAmount(40.0);
		product.setProductDescription("noodles");
		product.setAvailability("yes");
		
		Review review = new Review();
		review.setReviewId(5);
		review.setRating(8);
		review.setFeedback("Good");
		review.setProduct(product);
		
		when(reviewRepository.save(review)).thenReturn(review);
		assertEquals(review,reviewService.saveOrUpdateReview(review));	
	}
	


}