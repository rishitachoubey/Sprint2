package com.cg.onlinegrocery.service;


import org.springframework.stereotype.Service;
import com.cg.onlinegrocery.domain.Item;


@Service
public interface ItemService {
	
	public Item saveOrUpdate(Item item);
	 public Iterable<Item> findAll();	
	//public void deleteItemById(int orderId, int itemId);

}
