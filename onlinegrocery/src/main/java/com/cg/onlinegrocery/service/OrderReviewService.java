package com.cg.onlinegrocery.service;

import java.util.Optional;

import com.cg.onlinegrocery.domain.Order_Review;

/**
 * This class provides the list of services offered by the Order class
 * @author Jayasri Vejendla
 *
 */

public interface OrderReviewService {

	
		Order_Review ConfirmOrder(Order_Review order);

		Order_Review UpdateOrder(Order_Review order);

		Iterable<Order_Review> getAllOrders();
		
		Optional<Order_Review> OrderReview(int OrderId);

		//Optional<Order_Review> DeleteOrder(int OrderId);

		int removeOrder(int orderId);
		//String removeOrder(String customerName);
		

		
	}

