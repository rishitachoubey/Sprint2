package com.cg.onlinegrocery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlinegrocery.domain.Item;

/**
 * This class provides repository for Item class by extending the CRUD repository
 * @author Rishita
 *
 */

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

	Item findByItemName(String itemName);
	
	
}
