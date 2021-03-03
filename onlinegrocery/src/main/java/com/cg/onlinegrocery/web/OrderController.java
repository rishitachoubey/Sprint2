package com.cg.onlinegrocery.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.service.MapValidationErrorService;
import com.cg.onlinegrocery.service.OrderService;

/**
 * This is the controller class which provides the end points foe the
 * application
 * 
 * @author Rishita
 *
 */
@RestController
@RequestMapping("/api/orders")

public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewOrder(@Valid @RequestBody Order order, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Order ord = orderService.saveOrUpdate(order);
		return new ResponseEntity<Order>(ord, HttpStatus.OK);
	}

	@GetMapping("/{orderIdentifier}")
	public ResponseEntity<?> getOrderByIdentifier(@PathVariable String orderIdentifier) {
		Order order = orderService.findOrderByOrderIdentifier(orderIdentifier.toUpperCase());
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@DeleteMapping("/{orderIdentifier}")
	public ResponseEntity<?> deleteOrder(@PathVariable String orderIdentifier) {
		orderService.deleteOrderByIdentifier(orderIdentifier);
		return new ResponseEntity<String>("Order with id : " + orderIdentifier.toUpperCase() + " deleted successfully.",
				HttpStatus.OK);
	}

}
