package com.cg.onlinegrocery.serviceimpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinegrocery.domain.Order_Review;
import com.cg.onlinegrocery.exception.OrderNotFoundException;
import com.cg.onlinegrocery.repository.OrderReviewRepository;
import com.cg.onlinegrocery.service.OrderReviewService;
import com.cg.onlinegrocery.serviceimpl.OrderReviewServiceImpl;
/**
 * This service implementation class will provide implementations to the service
 * layer
 * 
 * @author Jayasri Vejendla
 *
 */

@Service

public class OrderReviewServiceImpl  implements OrderReviewService {

	@Autowired
	
	OrderReviewRepository repository;

	@Override
	public Order_Review ConfirmOrder(Order_Review order) {
		//int Order_id = order.getOrder_id();
		//if (repository.findById(Order_id) != null)
			
		return repository.save(order);
		//else
			//throw new OrderNotFoundException("Order for confirm is not present with the id" + Order_id);
	}
	
	@Override
	public Order_Review UpdateOrder(Order_Review order) {
		//int Order_id = order.getOrder_id();
		//if (repository.findById(Order_id) != null)
			
		return repository.save(order);
		//else
			//throw new OrderNotFoundException("Order for update is not present with the id" + Order_id);
	}
	
	
	
	@Override
	public Iterable<Order_Review> getAllOrders() {
	return repository.findAll();
	
	}

	@Override
	public Optional<Order_Review> OrderReview(int OrderId) {
		
        return repository.findById(OrderId);
		
		
	}

	//@Override
	//public Optional<Order_Review> DeleteOrder(int OrderId) {
		// TODO Auto-generated method stub
		
	   //	return repository.findById(OrderId);
		
	//}  
	public int removeOrder(int OrderId) throws OrderNotFoundException{
		Optional<Order_Review> orderreview = repository.findById(OrderId);
		if(orderreview==null)
		{
			throw new OrderNotFoundException("No order found with this id");
		}
		else
		{
		repository.delete(orderreview.get());
	   	    return OrderId;	
		}
   	    
	}
	
	}

	

	

		

