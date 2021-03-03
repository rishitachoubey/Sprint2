package com.cg.onlinegrocery.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinegrocery.domain.TrackingStatus;
import com.cg.onlinegrocery.service.TrackingStatusService;

@RestController
@RequestMapping(value="/api")
public class TrackingStatusController {

	@Autowired
	private TrackingStatusService trackingStatusService;


	@GetMapping("/track/{orderId}")
	public List<TrackingStatus> trackOrder(@PathVariable("orderId") Integer orderId) {

		return trackingStatusService.getTrackingData(orderId);

	}

	/*Store in charge and Admin will update*/
	@PostMapping("/track")
	public void updateTrackStatus(@RequestBody TrackingStatus trackStatus) {

		trackingStatusService.updateTrackStatus(trackStatus);

	}


}