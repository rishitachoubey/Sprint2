package com.cg.onlinegrocery.service;

import java.util.Optional;

import com.cg.onlinegrocery.domain.Order_Review;

public interface OrderReviewService {

	
		Order_Review ConfirmOrder(Order_Review order);

		Order_Review UpdateOrder(Order_Review order);

		Iterable<Order_Review> getAllOrders();
		
		Optional<Order_Review> OrderReview(int OrderId);

		void CancelOrderById(int id);
		

		
	}