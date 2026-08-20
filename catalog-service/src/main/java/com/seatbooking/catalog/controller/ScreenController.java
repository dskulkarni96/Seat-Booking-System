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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seatbooking.catalog.dto.ScreenRequest;
import com.seatbooking.catalog.dto.ScreenResponse;
import com.seatbooking.catalog.service.ScreenService;

@RestController
@RequestMapping("/api")
public class ScreenController {
	
	private final ScreenService screenService;

	public ScreenController(ScreenService screenService) {
		this.screenService = screenService;
	}
	
	@PostMapping("/screens")
	public ResponseEntity<ScreenResponse> saveScreen(@RequestBody ScreenRequest screenRequest) {
		ScreenResponse screen = screenService.addScreen(screenRequest);
		return new ResponseEntity<>(screen,HttpStatus.CREATED);
	}
	@GetMapping("/screens/{id}")
	public ResponseEntity<ScreenResponse> getScreenById(@PathVariable int id) {
		ScreenResponse screenResponse = screenService.getScreenById(id);
		return new ResponseEntity<>(screenResponse,HttpStatus.OK);
	}
	@GetMapping("/screens")
	public ResponseEntity<List<ScreenResponse>> getAllScreens() {
		List<ScreenResponse> screens = screenService.getAllScreens();
		return new ResponseEntity<>(screens,HttpStatus.OK);
	}
	@DeleteMapping("/screens/{id}")
	public void deleteScreenById(@PathVariable int id) {
		screenService.deleteScreenById(id);
	}
	@GetMapping("/screens/screenById")
	public ResponseEntity<List<ScreenResponse>> getScreensByTheatreId(@RequestParam int theatreId){
		List<ScreenResponse> screenResponse = screenService.findScreensByTheatreId(theatreId);
		return new ResponseEntity<>(screenResponse,HttpStatus.OK);
	}

}
