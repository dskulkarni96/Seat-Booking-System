package com.seatbooking.inventory.dto;

public class BookSeatRequest {

    private Integer seatId;
    private Integer showId;

    public BookSeatRequest() {
    }

    public BookSeatRequest(Integer seatId, Integer showId) {
        this.seatId = seatId;
        this.showId = showId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }
}