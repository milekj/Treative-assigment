package com.milekj.treative_assignment.repository;

import com.milekj.treative_assignment.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("select count(t) from Flight f inner join f.tourists t ")
    int getBookedPlacesNumber(long flightId);
}
