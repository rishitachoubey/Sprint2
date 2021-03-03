package com.cg.onlinegrocery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinegrocery.domain.TrackingStatus;

@Repository
public interface TrackingStatusRepository  extends CrudRepository<TrackingStatus, Integer> { 
	
	List<TrackingStatus> findByOrderOrderId(Integer OrderOrderId);
	
	

}