package com.cg.onlinegrocery.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinegrocery.domain.TrackingStatus;
import com.cg.onlinegrocery.repository.TrackingStatusRepository;
import com.cg.onlinegrocery.service.TrackingStatusService;

@Service
public class TrackingStatusServiceImpl implements TrackingStatusService {
	
	@Autowired
	TrackingStatusRepository trackingStatusRepository;
	
	@Override
	public List<TrackingStatus> getTrackingData(Integer orderId){
		
		return trackingStatusRepository.findByOrderOrderId(orderId);
		
	}

	@Override
	public void updateTrackStatus(TrackingStatus trackStatus) {
		trackingStatusRepository.save(trackStatus);
	}

}