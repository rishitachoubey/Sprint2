package com.cg.onlinegrocery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinegrocery.domain.Order;
import com.cg.onlinegrocery.domain.TrackingStatus;
import com.cg.onlinegrocery.repository.TrackingStatusRepository;
import com.cg.onlinegrocery.service.TrackingStatusService;

@SpringBootTest
public class TrackingStatusServiceTest {
	
	@Autowired
	private TrackingStatusService trackingStatusService;
	
	@MockBean
	private TrackingStatusRepository trackingStatusRepository;
	
	@Test
	public void updateTrackStatus() {
	    TrackingStatus trackingStatus = new TrackingStatus();
	    Order order=new Order();
	    order.setOrderId(5);
	    trackingStatus.setOrder(order);
	    trackingStatus.setTrackStatus("Confirmed");
	    trackingStatus.setDate(new Date());
		when(trackingStatusRepository.save(trackingStatus)).thenReturn(trackingStatus);
		assertEquals(trackingStatus,trackingStatusRepository.save(trackingStatus));
		
	}

}