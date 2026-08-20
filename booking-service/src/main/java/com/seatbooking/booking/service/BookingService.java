package com.seatbooking.booking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.seatbooking.booking.client.PaymentClient;
import com.seatbooking.booking.client.SeatInventoryClient;
import com.seatbooking.booking.controller.BookingController;
import com.seatbooking.booking.dto.BookSeatRequest;
import com.seatbooking.booking.dto.BookingRequest;
import com.seatbooking.booking.dto.BookingResponse;
import com.seatbooking.booking.dto.HoldSeatRequest;
import com.seatbooking.booking.dto.HoldSeatResponse;
import com.seatbooking.booking.dto.PaymentRequest;
import com.seatbooking.booking.dto.PaymentResponse;
import com.seatbooking.booking.entity.Booking;
import com.seatbooking.booking.entity.BookingSeat;
import com.seatbooking.booking.entity.BookingStatus;
import com.seatbooking.booking.producer.BookingEventProducer;
import com.seatbooking.booking.repository.BookingRepository;
import com.seatbooking.booking.repository.BookingSeatRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final SeatInventoryClient seatInventoryClient;
    private final BookingEventProducer bookingEventProducer;
    private final PaymentClient paymentClient;

    public BookingService(
            BookingRepository bookingRepository,
            BookingSeatRepository bookingSeatRepository,
            SeatInventoryClient seatInventoryClient,
            BookingEventProducer bookingEventProducer,
            PaymentClient paymentClient) {

        this.bookingRepository = bookingRepository;
        this.bookingSeatRepository = bookingSeatRepository;
        this.seatInventoryClient = seatInventoryClient;
        this.bookingEventProducer=bookingEventProducer;
        this.paymentClient=paymentClient;
    }

    public BookingResponse createRequest(BookingRequest bookingRequest) {

        List<HoldSeatResponse> heldSeats = new ArrayList<>();

        // Step 1: Hold each requested seat
        for (Integer seatId : bookingRequest.getSeatIds()) {

            HoldSeatRequest holdSeatRequest =
                    new HoldSeatRequest(
                            seatId,
                            bookingRequest.getShowId());

            HoldSeatResponse holdSeatResponse =
                    seatInventoryClient.holdSeat(holdSeatRequest);

            if (!"HELD".equalsIgnoreCase(holdSeatResponse.getStatus())) {
                throw new RuntimeException(
                        "Unable to hold seat: " + seatId);
            }

            heldSeats.add(holdSeatResponse);
        }

        // Step 2: Calculate total amount
        int pricePerSeat = 200;
        int totalAmount = heldSeats.size() * pricePerSeat;

        // Step 3: Create Booking
        Booking booking = new Booking();

        booking.setUserId(bookingRequest.getUserId());
        booking.setShowId(bookingRequest.getShowId());
        booking.setStatus(BookingStatus.PENDING);
        booking.setTotalAmount(totalAmount);
        booking.setCreatedAt(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);

        // Step 4: Create BookingSeat records
        for (HoldSeatResponse heldSeat : heldSeats) {

            BookingSeat bookingSeat = new BookingSeat();

            bookingSeat.setBookingId(savedBooking.getId());
            bookingSeat.setSeatId(heldSeat.getSeatId());
            bookingSeat.setPrice(pricePerSeat);

            bookingSeatRepository.save(bookingSeat);
        }
        
        //Step 5:  Call payment feign client to connect booking microservice with payment microservice
        
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setBookingId(savedBooking.getId());
        paymentRequest.setAmount(savedBooking.getTotalAmount());
        
        PaymentResponse paymentResponse = paymentClient.processPayment(paymentRequest);
        
        if ("SUCCESS".equalsIgnoreCase(paymentResponse.getStatus())) {

            savedBooking.setStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(savedBooking);
            
            for (HoldSeatResponse heldSeat : heldSeats) {

                BookSeatRequest bookSeatRequest =
                        new BookSeatRequest(
                                heldSeat.getSeatId(),
                                savedBooking.getShowId()
                        );

                seatInventoryClient.bookSeat(bookSeatRequest);
            }
            
            //kafka
            
          String eventMessage = String.format( "{\"bookingId\":%d,\"userId\":%d,\"showId\":%d,\"totalAmount\":%d}",
    		savedBooking.getId(),savedBooking.getUserId(),savedBooking.getShowId(),savedBooking.getTotalAmount());
    
            bookingEventProducer.sendBookingEventToNotification(eventMessage);
    

        } else {

            savedBooking.setStatus(BookingStatus.FAILED);
            bookingRepository.save(savedBooking);
            
        }


//

        // Step 7: Create response
        BookingResponse response = new BookingResponse();

        response.setId(savedBooking.getId());
        response.setUserId(savedBooking.getUserId());
        response.setShowId(savedBooking.getShowId());
        response.setStatus(savedBooking.getStatus().name());
        response.setCreatedAt(savedBooking.getCreatedAt());
        response.setTotalAmount(savedBooking.getTotalAmount());

        return response;
    }
}