package com.seatbooking.catalog.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.catalog.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
	
	List<Show> findByMovieIdAndScreenTheaterId(int movieId, int theatreId);
	boolean existsByScreenIdAndStartTimeLessThanAndEndTimeGreaterThan(
	        int screenId,
	        LocalDateTime endTime,
	        LocalDateTime startTime
	);

}
