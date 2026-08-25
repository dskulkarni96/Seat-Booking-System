package com.seatbooking.inventory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seatbooking.inventory.dto.BookSeatRequest;
import com.seatbooking.inventory.dto.HoldSeatRequest;
import com.seatbooking.inventory.dto.HoldSeatResponse;
import com.seatbooking.inventory.entity.ShowSeat;
import com.seatbooking.inventory.service.ShowSeatService;

@RestController
@RequestMapping("/inventory")
public class ShowSeatController {

    private final ShowSeatService seatInventoryService;

    public ShowSeatController(ShowSeatService seatInventoryService) {
        this.seatInventoryService = seatInventoryService;
    }

    @PostMapping("/hold")
    public ResponseEntity<HoldSeatResponse> holdSeat(
            @RequestBody HoldSeatRequest request) {

        HoldSeatResponse showSeat = seatInventoryService.holdSeat(request);
        return new ResponseEntity<>(showSeat,HttpStatus.OK);
    }
    
    @GetMapping("/shows/{showId}/seats")
    public ResponseEntity<List<HoldSeatResponse>> getSeatsByShowId(@PathVariable int showId){
    	List<HoldSeatResponse> seat = seatInventoryService.getSeatsByShowId(showId);
    	return new ResponseEntity<>(seat,HttpStatus.OK);
    }
    
    @PostMapping("/book")
    public ResponseEntity<String> bookSeat(
            @RequestBody BookSeatRequest request) {

        seatInventoryService.bookSeat(
                request.getShowId(),
                request.getSeatId()
        );

        return ResponseEntity.ok("Seat booked successfully");
    }
}