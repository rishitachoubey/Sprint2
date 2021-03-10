package com.cg.onlinegrocery.service;

import java.util.Optional;

import com.cg.onlinegrocery.domain.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product findProductByName(String productName);
	public Product deleteProductByName(String productName);

	//public void deleteProjectByIdentifier(String projectIdentifier);
//	Optional<Product> searchProduct(int productId);

}
