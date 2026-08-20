package com.seatbooking.booking.dto;

import java.time.LocalDateTime;

public class BookingResponse {
	
	private int id;
	private int showId;
	private int userId;
	private String status;
	private LocalDateTime createdAt;
	private int totalAmount;
	public BookingResponse(int id, int showId, int userId, String status, LocalDateTime createdAt, int totalAmount) {
		super();
		this.id = id;
		this.showId = showId;
		this.userId = userId;
		this.status = status;
		this.createdAt = createdAt;
		this.totalAmount = totalAmount;
	}
	public BookingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
