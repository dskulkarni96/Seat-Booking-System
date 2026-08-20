package com.seatbooking.catalog.dto;

public class SeatResponse {
	
	private int id;
	private String seatNumber;
	private int screenId;
	public SeatResponse(int id, String seatNumber, int screenId) {
		this.id = id;
		this.seatNumber = seatNumber;
		this.screenId = screenId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	

}
