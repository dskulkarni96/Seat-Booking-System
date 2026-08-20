package com.seatbooking.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatbooking.booking.dto.BookingRequest;
import com.seatbooking.booking.dto.BookingResponse;
import com.seatbooking.booking.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	private final BookingService bookingService;

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@PostMapping("/booking")
	public ResponseEntity<BookingResponse> bookSeats(@RequestBody BookingRequest bookingRequest){
		
		BookingResponse resp = bookingService.createRequest(bookingRequest);
		return new ResponseEntity<BookingResponse>(resp,HttpStatus.OK);
	}
	
}
