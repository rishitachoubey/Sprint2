package com.cg.onlinegrocery.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinegrocery.domain.Order;

/**
 * This class provides repository for Order class by extending the CRUD repository
 * @author Rishita
 *
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	Order findByOrderIdentifier(String orderIdentifier);	

}
