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
import com.seatbooking.catalog.dto.TheatreRequest;
import com.seatbooking.catalog.dto.TheatreResponse;
import com.seatbooking.catalog.service.TheatreService;

@RestController
@RequestMapping("/api")
public class TheatreController {
	
	private final TheatreService theatreService;
	public TheatreController(TheatreService theatreService) {
		this.theatreService = theatreService;
	}
	
	@PostMapping("/theatres")
	public ResponseEntity<TheatreResponse> saveTheatre(@RequestBody TheatreRequest theatreRequest) {
		TheatreResponse theatre = theatreService.addTheatre(theatreRequest);
		return new ResponseEntity<>(theatre,HttpStatus.CREATED);
	}
	@GetMapping("/theatres/{id}")
	public ResponseEntity<TheatreResponse> getTheatreById(@PathVariable int id) {
		TheatreResponse theatre = theatreService.getTheatreById(id);
		return new ResponseEntity<>(theatre,HttpStatus.OK);
	}
	@GetMapping("/theatres")
	public ResponseEntity<List<TheatreResponse>> getAllTheatres() {
		List<TheatreResponse> theatreResponses = theatreService.getAllTheatres();
		return new ResponseEntity<>(theatreResponses,HttpStatus.OK);
	}
	@DeleteMapping("/theatres/{id}")
	public void deleteTheatreById(@PathVariable int id) {
		 theatreService.deleteTheatreById(id);
	}

}
