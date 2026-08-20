package com.seatbooking.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.catalog.entity.Seat;

@Repository
public interface SeatRepository  extends JpaRepository<Seat, Integer> {
	
	boolean existsByScreenIdAndSeatNumber(int screenId, String seatNumber);

}
