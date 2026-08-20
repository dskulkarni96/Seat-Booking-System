package com.seatbooking.catalog.dto;

public class ScreenRequest {
	
	private String name;
	private int theatreId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public ScreenRequest(String name, int theatreId) {
		super();
		this.name = name;
		this.theatreId = theatreId;
	}
	
	

}
