package com.cg.onlinegrocery.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlinegrocery.domain.Order_Review;
import com.cg.onlinegrocery.repository.OrderReviewRepository;
import com.cg.onlinegrocery.service.OrderReviewService;


@RestController

public class OrderReviewController {
	
	@Autowired
	private OrderReviewService service;
	@Autowired
	private OrderReviewRepository repo;
	
	@PostMapping("/ConfirmOrder")
	public ResponseEntity<String> ConfirmOrder( @RequestBody Order_Review order)
	 {
		order = service.ConfirmOrder(order);
		return new ResponseEntity<String>("Order has been Confirm successfully" + order.getOrder_id(), HttpStatus.OK);

	}

	@PutMapping("/UpdateOrder")
	public ResponseEntity<String> UpdateOrder( @RequestBody Order_Review order) {
		order  = service.UpdateOrder(order);
		return new ResponseEntity<String>("Order has been updated successfully" + order.getOrder_id(), HttpStatus.OK);
	}

	@DeleteMapping("/CancelOrder")
	public ResponseEntity<String> CancelOrder(@RequestBody Order_Review order) {
//		service.CancelOrderById(orderId);
		repo.delete(order);
		return new ResponseEntity<String>("Order has been cancelled successfully" + order.getOrder_id(), HttpStatus.OK);
	}
	
	@GetMapping("/viewallOrder")
	public Iterable<Order_Review> viewallOrders(){
		return service.getAllOrders();
	}
	@GetMapping("/OrderReview/{orderId}")
	public Optional<Order_Review> OrderReviewByID(@PathVariable int orderId) {
		return service.OrderReview(orderId);
	}

		
	}

