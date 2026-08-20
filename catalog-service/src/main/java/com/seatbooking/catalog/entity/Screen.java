package com.seatbooking.catalog.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "screen")
	private List<Show> shows;
	@ManyToOne
	private Theatre theater;
	@OneToMany(mappedBy = "screen")
	private List<Seat> seats;
	public Screen(int id, String name, List<Show> shows, Theatre theater, List<Seat> seats) {
		super();
		this.id = id;
		this.name = name;
		this.shows = shows;
		this.theater = theater;
		this.seats = seats;
	}
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	public Theatre getTheater() {
		return theater;
	}
	public void setTheater(Theatre theater) {
		this.theater = theater;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	

}
