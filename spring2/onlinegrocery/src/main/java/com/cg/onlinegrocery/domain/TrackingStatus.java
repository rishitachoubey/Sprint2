package com.cg.onlinegrocery.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TrackingStatus")
public class TrackingStatus {  // Product status


	@Id
	@Column(name = "track_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trackId;
	
	@ManyToOne
	@JoinColumn(name ="order_id")
	private Order order;
	
	@Column(name = "track_status")
	private String trackStatus;  //order Status
	
	@Column(name = "status_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getTrackStatus() {
		return trackStatus;
	}

	public void setTrackStatus(String trackStatus) {
		this.trackStatus = trackStatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 

	
	
	
	



}

