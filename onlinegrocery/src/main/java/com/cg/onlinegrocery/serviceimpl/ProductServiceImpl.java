package com.cg.onlinegrocery.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinegrocery.domain.Product;
import com.cg.onlinegrocery.exception.ProductIdNotFoundException;
import com.cg.onlinegrocery.repository.ProductRepository;
import com.cg.onlinegrocery.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		try {
			
			return productRepository.save(product);
			}
			catch(Exception e)
			{
				throw new ProductIdNotFoundException("Product with" +product.getProductName()+ "already exists");
			}
	}

	@Override
	public Product updateProduct(Product product) {
		
		try {
			Product updateProduct1 =productRepository.findByProductName(product.getProductName());
			updateProduct1.setAvailability(product.getAvailability());
		    updateProduct1.setProductAmount(product.getProductAmount());
			return  productRepository.save(updateProduct1);
			}catch(Exception e)
			{ 
				throw new ProductIdNotFoundException("Product doesn't Exist");
			}
		
		
//		Product findProductByName(String productName) {
//			Product product1 = productRepository.findByProductName(productName);
//			if (product == null) {
//				throw new ProductIdNotFoundException("Product Name : " + productName + " does not exist");
//			}
//			return product;
//		}
	}

	@Override
	 public Product findProductByName(String productName) {
		Product product1 = productRepository.findByProductName(productName);
		if (product1 == null) {
			throw new ProductIdNotFoundException("Product Name : " + productName + " does not exist");
		}
		return product1;
	}


	@Override
	public Product deleteProductByName(String productName) {
		Product deleteProduct = productRepository.findByProductName(productName);
		if(deleteProduct != null) {
			productRepository.delete(deleteProduct);
			return deleteProduct;
		}
		else {
			throw new ProductIdNotFoundException("Product not found : "+productName);
		}
	}
}
		
//		if(productrepository.findById(productId)!=null)
//		return productrepository.save(product);
//		else
//			throw new ProductIdNotFoundException("Product for update");
//
//	@Override
//	public Optional<Product> searchProduct(int ProductId){
//		return repository.findById(ProductId);
//	}
//
//}
