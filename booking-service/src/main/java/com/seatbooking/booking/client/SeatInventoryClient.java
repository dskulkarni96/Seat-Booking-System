package com.seatbooking.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.seatbooking.booking.dto.BookSeatRequest;
import com.seatbooking.booking.dto.HoldSeatRequest;
import com.seatbooking.booking.dto.HoldSeatResponse;

@FeignClient(
    name = "seat-inventory-service",
    url = "http://localhost:8082"
)
public interface SeatInventoryClient {

    @PostMapping("/inventory/hold")
    HoldSeatResponse holdSeat(@RequestBody HoldSeatRequest request);
    
    @PostMapping("/inventory/book")
    String bookSeat(@RequestBody BookSeatRequest request);
}