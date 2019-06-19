package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.FlightDto;
import com.milekj.treative_assignment.dto.TouristDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;

import java.util.List;

public interface FlightService {
    List<Flight> getAll();
    Flight create(FlightDto flightDto);
    void deleteById(long id) throws ResourceNotFoundException;
    void update(long id, FlightDto flightDto) throws ResourceNotFoundException;
}
