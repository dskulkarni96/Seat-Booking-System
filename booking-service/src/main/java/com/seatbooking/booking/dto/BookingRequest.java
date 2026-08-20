package com.seatbooking.booking.dto;

import java.util.List;

public class BookingRequest {
	
	private int userId;
	private int showId;
	private List<Integer> seatIds;
	public BookingRequest(int userId, int showId, List<Integer> seatIds) {
		super();
		this.userId = userId;
		this.showId = showId;
		this.seatIds = seatIds;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int bookingId) {
		this.userId = bookingId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public List<Integer> getSeatIds() {
		return seatIds;
	}
	public void setSeatIds(List<Integer> seatIds) {
		this.seatIds = seatIds;
	}
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
