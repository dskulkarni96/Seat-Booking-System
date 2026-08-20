package com.seatbooking.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.catalog.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
