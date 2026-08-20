package com.seatbooking.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.catalog.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

	List<Screen> findByTheater_Id(int theatreId);
}
