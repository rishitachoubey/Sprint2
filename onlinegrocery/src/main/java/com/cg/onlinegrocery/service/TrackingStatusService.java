package com.cg.onlinegrocery.service;

import java.util.List;

import com.cg.onlinegrocery.domain.TrackingStatus;

public interface TrackingStatusService {

	public List<TrackingStatus> getTrackingData(Integer orderId);

	public void updateTrackStatus(TrackingStatus trackStatus);

}
