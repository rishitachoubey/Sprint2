/**
 * 
 * @author Meenali M. Rane
 * Description: This Class provides Connection to the Database. 
 * By Extending CrudRepository Interface, we can use basic CRUD Operations defined in it.
 * We now have to write only Specific Methods if Required.  
 * 
 */
package com.cg.onlinegrocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinegrocery.domain.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Integer>{

	@Query(value = "SELECT * FROM public.reviews WHERE product_id = ?;", nativeQuery = true)
	public List<Review> findAllByReview_Product_Id(int product_id);

}
