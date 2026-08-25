package com.seatbooking.inventory.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.seatbooking.inventory.dto.HoldSeatRequest;
import com.seatbooking.inventory.dto.HoldSeatResponse;
import com.seatbooking.inventory.entity.SeatStatus;
import com.seatbooking.inventory.entity.ShowSeat;
import com.seatbooking.inventory.exception.ResourceNotFoundException;
import com.seatbooking.inventory.exception.SeatNotAvailableException;
import com.seatbooking.inventory.repository.ShowSeatRepository;
import jakarta.transaction.Transactional;

@Service
public class ShowSeatService {

    private final ShowSeatRepository showSeatRepository ;

    public ShowSeatService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional
    public HoldSeatResponse holdSeat(HoldSeatRequest holdSeatRequest) {
    	try {
    	ShowSeat showSeat = showSeatRepository.findByShowIdAndSeatId(holdSeatRequest.getShowId(), holdSeatRequest.getSeatId())
    			.orElseThrow(()->new ResourceNotFoundException("Seat not found for this show"));
    	
    	if(showSeat.getStatus()!=SeatStatus.AVAILABLE) {
    		throw new SeatNotAvailableException("Seat is not available");
        }
    	showSeat.setStatus(SeatStatus.HELD);
        showSeat.setHeldUntil(LocalDateTime.now().plusMinutes(10));
        
        ShowSeat savedSeat =  showSeatRepository.save(showSeat);
        
        return new HoldSeatResponse(savedSeat.getId(), savedSeat.getShowId(), savedSeat.getSeatId(), savedSeat.getStatus(), savedSeat.getHeldUntil(), savedSeat.getVersion());
    }catch(ObjectOptimisticLockingFailureException e) {
    	throw new SeatNotAvailableException("Seat is already booked by another user. Try different seat");
    }
   }
    
    public List<HoldSeatResponse> getSeatsByShowId(int showId) {
    	List<ShowSeat> showSeat = showSeatRepository.findByShowId(showId);
        return showSeat.stream().map(savedSeat->new HoldSeatResponse(savedSeat.getId(), savedSeat.getShowId(), savedSeat.getSeatId(), savedSeat.getStatus(), savedSeat.getHeldUntil(), savedSeat.getVersion())).toList();
        		}
    
    @Scheduled(fixedRate = 60000)
    public void releaseExpiredSeats() {

        List<ShowSeat> expiredSeats =
                showSeatRepository.findByStatusAndHeldUntilBefore(
                        SeatStatus.HELD,
                        LocalDateTime.now()
                );

        for (ShowSeat seat : expiredSeats) {
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setHeldUntil(null);
        }

        showSeatRepository.saveAll(expiredSeats);
    }
    
    public void bookSeat(Integer showId, Integer seatId) {

        ShowSeat showSeat = showSeatRepository
                .findByShowIdAndSeatId(showId, seatId)
                .orElseThrow(() ->
                        new RuntimeException("Seat not found"));

        if (showSeat.getStatus() != SeatStatus.HELD) {
            throw new RuntimeException(
                    "Seat is not in HELD state"
            );
        }

        showSeat.setStatus(SeatStatus.BOOKED);

        showSeatRepository.save(showSeat);
    }
}