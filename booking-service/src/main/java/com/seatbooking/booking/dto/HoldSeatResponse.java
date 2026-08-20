package com.seatbooking.booking.dto;

import java.time.LocalDateTime;



public class HoldSeatResponse {
	private Integer id;
	private int showId;
	private int seatId;
	private String status;
	private LocalDateTime heldUntil;
	private int version;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public LocalDateTime getHeldUntil() {
		return heldUntil;
	}
	public void setHeldUntil(LocalDateTime heldUntil) {
		this.heldUntil = heldUntil;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public HoldSeatResponse(Integer id, int showId, int seatId, String status, LocalDateTime heldUntil, int version) {
		super();
		this.id = id;
		this.showId = showId;
		this.seatId = seatId;
		this.status = status;
		this.heldUntil = heldUntil;
		this.version = version;
	}
	public HoldSeatResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
