package com.cg.onlinegrocery.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinegrocery.domain.Order_Review;


@Repository
public interface OrderReviewRepository extends CrudRepository<Order_Review, Integer>{

		

	}
