package com.seatbooking.catalog.dto;

public class MovieRequest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieRequest(String name) {
		super();
		this.name = name;
	}
	

}
