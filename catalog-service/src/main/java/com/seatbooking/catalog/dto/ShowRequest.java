package com.seatbooking.catalog.dto;

import java.time.LocalDateTime;

public class ShowRequest {

	private int movieId;
	private int screenId;
	private LocalDateTime startTime;	
	private LocalDateTime endTime;

	public ShowRequest() {
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getScrennId() {
		return screenId;
	}
	public void setScrennId(int screenId) {
		this.screenId = screenId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public ShowRequest(int movieId, int screenId, LocalDateTime startTime, LocalDateTime endTime) {
		this.movieId = movieId;
		this.screenId = screenId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
}
