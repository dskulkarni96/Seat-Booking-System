package com.seatbooking.catalog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seatbooking.catalog.dto.MovieRequest;
import com.seatbooking.catalog.dto.MovieResponse;
import com.seatbooking.catalog.entity.Movie;
import com.seatbooking.catalog.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	
	final private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping("/movies")
	public ResponseEntity<MovieResponse> saveMovie(@RequestBody MovieRequest movieRequest) {
		MovieResponse movie = movieService.addMovie(movieRequest);
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
	}
	@GetMapping("/movies/{id}")
	public ResponseEntity<MovieResponse> getMovieById(@PathVariable int id) {
		MovieResponse movieResponse = movieService.getMovieById(id);
		return new ResponseEntity<>(movieResponse,HttpStatus.OK);
	}
	@GetMapping("/movies")
	public ResponseEntity<List<MovieResponse>> getAllMovies() {
		List<MovieResponse> movie = movieService.getAllMovies();
		return new ResponseEntity<>(movie,HttpStatus.OK);
	}
	@DeleteMapping("/movies/{id}")
	public void deleteMovieById(@PathVariable int id) {
		 movieService.deleteMovieById(id);
	}

}
