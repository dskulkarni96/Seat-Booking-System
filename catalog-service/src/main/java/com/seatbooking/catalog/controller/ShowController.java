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
import com.seatbooking.catalog.dto.ShowRequest;
import com.seatbooking.catalog.dto.ShowResponse;
import com.seatbooking.catalog.repository.ShowRepository;
import com.seatbooking.catalog.service.ShowService;

@RestController
@RequestMapping("/api")
public class ShowController {


	final private ShowService showService;

	public ShowController(ShowService showService) {
		this.showService = showService;
	}
	
	@PostMapping("/shows")
	public ResponseEntity<ShowResponse> saveShow(@RequestBody ShowRequest showRequest) {
		ShowResponse show = showService.addShow(showRequest);
		return new ResponseEntity<>(show,HttpStatus.CREATED);
	}
	@GetMapping("/shows/{id}")
	public ResponseEntity<ShowResponse> getShowById(@PathVariable int id) {
		ShowResponse showResponse = showService.getShowById(id);
		return new ResponseEntity<>(showResponse,HttpStatus.OK);
	}
	@GetMapping("/shows")
	public ResponseEntity<List<ShowResponse>> getAllShows() {
		List<ShowResponse> shows = showService.getAllShows();
		return new ResponseEntity<>(shows,HttpStatus.OK);
	}
	@DeleteMapping("/shows/{id}")
	public void deleteShowById(@PathVariable int id) {
		showService.deleteShowById(id);
	}
	@GetMapping("/shows/movieByScreenAndTheatre")
	public ResponseEntity<List<ShowResponse>> findByMovieIdAndScreenTheaterId(@RequestParam int movieId, @RequestParam int theatreId){
		List<ShowResponse> showResponse = showService.findByMovieIdAndScreenTheaterId(movieId, theatreId);
		return new ResponseEntity<>(showResponse,HttpStatus.OK);
	}

	}
