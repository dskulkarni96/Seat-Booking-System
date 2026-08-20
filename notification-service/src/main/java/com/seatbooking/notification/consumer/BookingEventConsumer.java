package com.seatbooking.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookingEventConsumer {
	
	@KafkaListener(topics = "booking-events",groupId = "notification-group")
	public void consumeBookingEvent(String message) {
		System.out.println("Receiving Booking Event : " +message);
	}
		
	

}
