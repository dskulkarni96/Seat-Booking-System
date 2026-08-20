package com.seatbooking.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.catalog.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
