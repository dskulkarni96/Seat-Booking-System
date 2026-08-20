package com.seatbooking.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.seatbooking.booking.dto.PaymentRequest;
import com.seatbooking.booking.dto.PaymentResponse;

@FeignClient(
        name = "payment-service",
        url = "http://localhost:8084"
)
public interface PaymentClient {

    @PostMapping("/payments")
    PaymentResponse processPayment(
            @RequestBody PaymentRequest request);
}