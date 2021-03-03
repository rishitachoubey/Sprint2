package com.cg.onlinegrocery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.repository.ProductRepository;
import com.cg.onlinegrocery.service.ProductService;

@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	public void saveProductTest() {
		Product product = new Product();
		product.setProductName("Sugar");
		product.setProductAmount(40.0);
		product.setProductDescription("Sugar");
		product.setAvailability("5");
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product,service.saveProduct(product));
		
	}

}