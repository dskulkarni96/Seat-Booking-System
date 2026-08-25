package com.seatbooking.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class ShowSeat {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	private int showId;
	private int seatId;
	@Enumerated(EnumType.STRING)
	private SeatStatus status;
	private LocalDateTime heldUntil;
	@Version
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
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
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
	public ShowSeat(Integer id, int showId, int seatId, SeatStatus status, LocalDateTime heldUntil, int version) {
		super();
		this.id = id;
		this.showId = showId;
		this.seatId = seatId;
		this.status = status;
		this.heldUntil = heldUntil;
		this.version = version;
	}
	public ShowSeat() {
		super();// TODO Auto-generated constructor stub
	}

}
