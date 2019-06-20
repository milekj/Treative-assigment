package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.FlightRequestDto;
import com.milekj.treative_assignment.dto.FlightResponseDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.exception.InvalidPlacesNumberException;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;

import java.util.List;

public interface FlightService {
    List<FlightResponseDto> getAll();
    FlightResponseDto create(FlightRequestDto flightRequestDto);
    void deleteById(long id) throws ResourceNotFoundException;
    void update(long id, FlightRequestDto flightRequestDto) throws ResourceNotFoundException, InvalidPlacesNumberException;
    void addTourist(long flightId, long touristId) throws ResourceNotFoundException, InvalidPlacesNumberException;
    void deleteTourist(long flightId, long touristId) throws ResourceNotFoundException;
    Flight getFlightByIdOrThrow(long id) throws ResourceNotFoundException;
}
