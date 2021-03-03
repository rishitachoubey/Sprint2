package com.cg.onlinegrocery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinegrocery.domain.Item;
import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.repository.OrderRepository;
import com.cg.onlinegrocery.service.OrderService;




@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

	@Autowired
	 private OrderService orderService;
	
	@MockBean
	 private OrderRepository orderRepository;
	
	@Test
	public void saveOrUpdateOrderTest() {
		
		Order order = new Order();
		order.setOrderId(1);
		order.setCustName("Rishita");
		order.setOrderIdentifier("ord1");
		order.setAmount(50.00);
		
		
		Item item = new Item();
		item.setItemId(5);
		item.setItemName("milk");
		item.setItemPrice(5.00);
		item.setItemQuantity(10);
		
		
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order,orderService.saveOrUpdate(order));	
	}
	
	@Test
	public void findAllOrderTest()
	{
		Order order= new Order();
		order.setOrderId(1);
		order.setCustName("Rishita");
		order.setOrderIdentifier("ord1");
		order.setAmount(50.00);
		
		Order order1= new Order();
		order1.setOrderId(2);
		order1.setCustName("Riya");
		order1.setOrderIdentifier("ord2");
		order1.setAmount(100.00);
		
		List<Order> orderList=new ArrayList<>();
		orderList.add(order);
		orderList.add(order1);
		Mockito.when(orderRepository.findAll()).thenReturn(orderList);
		assertThat(orderService.getAllOrders()).isEqualTo(orderList);
	}
	
	@Test
	public void deleteOrderTest()
	{
		Order order=new Order();
		order.setOrderId(1);
		order.setCustName("Rishita");
		order.setOrderIdentifier("ord1");
		order.setAmount(50.00);
		Mockito.when(orderRepository.findByOrderIdentifier(order.getOrderIdentifier().toUpperCase())).thenReturn(order);
		Mockito.when(orderRepository.existsById(order.getOrderId())).thenReturn(false);
		assertFalse(orderRepository.existsById(order.getOrderId()));
	}
	


}