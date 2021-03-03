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

import com.cg.onlinegrocery.domain.Item;
import com.cg.onlinegrocery.service.ItemService;
import com.cg.onlinegrocery.service.MapValidationErrorService;



@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewOrder(@Valid @RequestBody Item item, BindingResult result)
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Item item1= itemService.saveOrUpdate(item);
		return new ResponseEntity<Item>(item1, HttpStatus.OK );
	}

	@GetMapping("/all")
	public Iterable<Item> getAllItems(){
		return itemService.findAll();
	}
	
//	@DeleteMapping("/{orderId}/{itemId}")
//	public ResponseEntity<?> deleteItem(@PathVariable int orderId, @PathVariable int itemId) {
//		itemService.deleteItemById(orderId, itemId);
//		return new ResponseEntity<String>("Item with id : "+itemId+" deleted successfully.",HttpStatus.OK);
//	}


}
