package com.seatbooking.booking.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingEventProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public BookingEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendBookingEventToNotification(String message) {
		kafkaTemplate.send("booking-events",  message);
	}
	
}
