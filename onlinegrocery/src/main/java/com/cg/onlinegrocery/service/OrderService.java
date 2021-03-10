package com.cg.onlinegrocery.service;
import org.springframework.stereotype.Service;
import com.cg.onlinegrocery.domain.Order;


/**
 * This class provides the list of services offered by the Order class
 * @author Rishita
 *
 */
@Service
public interface OrderService  {
	
	
	public Order saveOrUpdate(Order order);
	
//	public Order findOrderByOrderIdentifier(String orderIdentifier);
	
	public Iterable<Order> getAllOrders();
	
//	public void deleteOrderByIdentifier(String orderIdentifier);

}
