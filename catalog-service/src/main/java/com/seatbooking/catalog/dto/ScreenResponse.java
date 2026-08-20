package com.seatbooking.catalog.dto;

public class ScreenResponse {
	
	private int id;
	private String name;
	private int theatreId;
	public ScreenResponse(int id, String name, int theatreId) {
		this.id = id;
		this.name = name;
		this.theatreId = theatreId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

	
}
