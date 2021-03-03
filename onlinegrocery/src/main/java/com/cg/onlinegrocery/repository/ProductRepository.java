package com.cg.onlinegrocery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlinegrocery.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>  {
	 Product findByProductName(String productName);

	Product findByProductId(int productId);
	

	

}
