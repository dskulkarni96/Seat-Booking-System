package com.seatbooking.catalog.dto;

import java.time.LocalDateTime;

public class ShowResponse {

	private int id;
	private int movieId;
	private int scrennId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	public ShowResponse(int id, int movieId, int scrennId, LocalDateTime startTime, LocalDateTime endTime) {
		this.id = id;
		this.movieId = movieId;
		this.scrennId = scrennId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getScrennId() {
		return scrennId;
	}
	public void setScrennId(int scrennId) {
		this.scrennId = scrennId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	
}
