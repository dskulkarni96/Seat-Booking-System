package com.seatbooking.inventory.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seatbooking.inventory.entity.SeatStatus;
import com.seatbooking.inventory.entity.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
	
	List<ShowSeat> findByShowId(int showId);
    Optional<ShowSeat> findByShowIdAndSeatId(int showId, int seatId);

    List<ShowSeat> findByStatusAndHeldUntilBefore(
            SeatStatus status,
            LocalDateTime time);
}
