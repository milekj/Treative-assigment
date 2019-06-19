package com.milekj.treative_assignment.repository;

import com.milekj.treative_assignment.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
