package com.seatbooking.inventory.dto;

public class HoldSeatRequest {
	
	private int seatId;
	private int showId;
	public HoldSeatRequest(int seatId, int showId) {
		super();
		this.seatId = seatId;
		this.showId = showId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public HoldSeatRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
