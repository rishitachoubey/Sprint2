package com.cg.onlinegrocery.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinegrocery.domain.Item;
import com.cg.onlinegrocery.exception.ItemNotFoundException;
import com.cg.onlinegrocery.repository.ItemRepository;
import com.cg.onlinegrocery.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item saveOrUpdate(Item item) {
	   
		//Exceptions:
		// 1. Item Name == Product Name
		// 2. Product Count< itemQuantity 
		
		return itemRepository.save(item);
	  
	}
	
	
	@Override
	 public Iterable<Item> findAll() {
	        return itemRepository.findAll();
	    }

		
//	}
//	@Override
//	public void deleteItemById(int orderId, int itemId) {
//		Item item = findItemById(orderId,itemId);
//     itemRepository.delete(item);
//		
//	}
//	

}
