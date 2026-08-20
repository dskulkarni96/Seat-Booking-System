package com.seatbooking.booking.dto;

public class BookingCreatedEvent {

    private Long bookingId;
    private Long userId;
    private Long showId;
    private Double totalAmount;
	public BookingCreatedEvent(Long bookingId, Long userId, Long showId, Double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.showId = showId;
		this.totalAmount = totalAmount;
	}
	public BookingCreatedEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

    
}