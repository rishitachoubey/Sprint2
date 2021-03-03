package com.cg.onlinegrocery.serviceimpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinegrocery.domain.Order_Review;
import com.cg.onlinegrocery.exception.OrderNotFoundException;
import com.cg.onlinegrocery.repository.OrderReviewRepository;
import com.cg.onlinegrocery.service.OrderReviewService;
import com.cg.onlinegrocery.serviceimpl.OrderReviewServiceImpl;


@Service

public class OrderReviewServiceImpl  implements OrderReviewService {

	@Autowired
	
	OrderReviewRepository repository;

	@Override
	public Order_Review ConfirmOrder(Order_Review order) {
		int Order_id = order.getOrder_id();
		if (repository.findById(Order_id) != null)
			
		return repository.save(order);
		else
			throw new OrderNotFoundException("Order for confirm is not present with the id" + Order_id);
	}
	
	@Override
	public Order_Review UpdateOrder(Order_Review order) {
		int Order_id = order.getOrder_id();
		if (repository.findById(Order_id) != null)
			
		return repository.save(order);
		else
			throw new OrderNotFoundException("Order for update is not present with the id" + Order_id);
	}
	
	@Override
	public void CancelOrderById(int id)
    {
   	 repository.deleteById(id);
    }
	
	@Override
	public Iterable<Order_Review> getAllOrders() {
	return repository.findAll();
	
	}

	@Override
	public Optional<Order_Review> OrderReview(int OrderId) {
		
        return repository.findById(OrderId);
		
		
	}
		
}
		

