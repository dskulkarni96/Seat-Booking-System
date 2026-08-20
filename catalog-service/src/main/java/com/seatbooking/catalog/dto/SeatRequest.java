package com.seatbooking.catalog.dto;

public class SeatRequest {
	private String seatNumber;
	private int screenId;
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public SeatRequest(String seatNumber, int screenId) {
		super();
		this.seatNumber = seatNumber;
		this.screenId = screenId;
	}

	
}
