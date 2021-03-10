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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/SaveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product)
	{
		product =service.saveProduct(product);
		return new ResponseEntity<String>("Product saved successfully",HttpStatus.OK);
	}
	
	@PutMapping("/UpdateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		Product product2=service.updateProduct(product);
		return new ResponseEntity<String>("Product updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/{productName}")
	public ResponseEntity<?> deleteProduct(@PathVariable String productName) {
		Product deleteProduct=service.deleteProductByName(productName);
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
	

	
	@GetMapping("/SearchProduct/{productName}")
	public ResponseEntity<?> findProductByName(@PathVariable String productName){
		Product product = service.findProductByName(productName);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
//	@GetMapping("/{email}")
//	public ResponseEntity<?> viewProfile(@PathVariable String email){
//		User user = userservice.findUserByEmail(email);
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//	}
	
	//public Optional<Product> searchProductById(@PathVariable int ProductId)
//	{
//		return service.searchProduct(ProductId);
//		}

}
