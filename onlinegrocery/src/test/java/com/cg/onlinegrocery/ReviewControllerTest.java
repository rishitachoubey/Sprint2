/**
 * 
 * @author Meenali M. Rane
 * Description: This Class has Review Controller Mockito Test Cases
 * 
 */
package com.cg.onlinegrocery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinegrocery.domain.Review;
import com.cg.onlinegrocery.service.ReviewService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinegroceryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private ReviewService reviewService;
	
	@LocalServerPort
	private int port;

	private Review review;
	
	/**
	 * Retrieving Root URL
	 */
	private String getRootUrl()
	{
		return "http://localhost:" + port;
	}
	
	@BeforeEach
	public void setMockData()
	{	
        review = new Review(1,9,"Excellent",null);
	}
	
	/**
	 * Testing addReview method
	 */
	@Test
	void testAddReview()
	{	
		ResponseEntity<Review> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/products/reviews/add", review, Review.class);
		System.out.println("Review : "+review);
		assertNotNull(postResponse);
	}
	
	/**
	 * Testing deleteReview method
	 */
	@SuppressWarnings("unused")
	@Test
	void testDeleteReview()
	{
		ResponseEntity<Review> postResponse1 = restTemplate.postForEntity(getRootUrl() + "/api/products/reviews/add", review, Review.class);
		Review postResponse2 = restTemplate.getForObject(getRootUrl() + "/api/products/reviews/1/delete",Review.class);
		restTemplate.delete(getRootUrl() + "/api/products/reviews/1/delete", Review.class);
		Review postResponse3 = restTemplate.getForObject(getRootUrl() + "/api/products/reviews/1/delete",Review.class);
		assertEquals(null, postResponse3);
	}

}