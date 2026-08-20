package com.seatbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seatbooking.booking.entity.BookingSeat;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Integer> {

}
