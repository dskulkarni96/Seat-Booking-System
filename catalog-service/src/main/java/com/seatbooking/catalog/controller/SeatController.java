package com.seatbooking.catalog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatbooking.catalog.dto.SeatRequest;
import com.seatbooking.catalog.dto.SeatResponse;

import com.seatbooking.catalog.service.SeatService;

@RestController
@RequestMapping("/api")
public class SeatController {


	final private SeatService seatService;

	public SeatController(SeatService seatService) {
		this.seatService = seatService;
	}
	
	@PostMapping("/seats")
	public ResponseEntity<SeatResponse> saveSeat(@RequestBody SeatRequest seatRequest) {
		SeatResponse seat = seatService.addSeat(seatRequest);
		return new ResponseEntity<>(seat,HttpStatus.CREATED);
	}
	@GetMapping("/seats/{id}")
	public ResponseEntity<SeatResponse> getSeatById(@PathVariable int id) {
		SeatResponse seatResponse = seatService.getSeatById(id);
		return new ResponseEntity<>(seatResponse,HttpStatus.OK);
	}
	@GetMapping("/seats")
	public ResponseEntity<List<SeatResponse>> getAllSeats() {
		List<SeatResponse> seats = seatService.getAllSeats();
		return new ResponseEntity<>(seats,HttpStatus.OK);
	}
	@DeleteMapping("/seats/{id}")
	public void deleteSeatById(@PathVariable int id) {
		seatService.deleteSeatById(id);
	}
}
