package com.cg.onlinegrocery.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinegrocery.domain.Item;
import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.exception.OrderIdException;
import com.cg.onlinegrocery.repository.OrderRepository;
import com.cg.onlinegrocery.service.OrderService;

/**
 * This service implementation class will provide implementations to the service
 * layer
 * 
 * @author Rishita
 *
 */

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrUpdate(Order order) {
		try {
             Product product= new Product();
			order.setOrderIdentifier(order.getOrderIdentifier().toUpperCase());
			// Amount calculation logic
			double grossTotal = calculateAmountFromItems(order);
			order.setAmount(grossTotal);

			return orderRepository.save(order);
		} catch (Exception e) {
			throw new OrderIdException("Order Id" + order.getOrderIdentifier().toUpperCase() + " already exists");
		}

	}

	private double calculateAmountFromItems(Order order) {
		List<Item> items = order.getItems();
		double grossTotal = 0.0;
		for (Item item : items) {
			int qty = item.getItemQuantity();
			double price = item.getItemPrice();
			double cost = qty * price;
			grossTotal += cost;

		}
		return grossTotal;
	}

	@Override
	public Order findOrderByOrderIdentifier(String orderIdentifier) {
		Order order = orderRepository.findByOrderIdentifier(orderIdentifier.toUpperCase());
		if (order == null) {
			throw new OrderIdException("Order Id : " + orderIdentifier.toUpperCase() + " does not exist");
		}
		return order;
	}

	@Override
	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrderByIdentifier(String orderIdentifier) {
		Order order = orderRepository.findByOrderIdentifier(orderIdentifier.toUpperCase());
		if (order == null) {
			throw new OrderIdException(
					"Can not delete order with id : " + orderIdentifier.toUpperCase() + ". This order does not exist");
		}
		orderRepository.delete(order);
	}

}
