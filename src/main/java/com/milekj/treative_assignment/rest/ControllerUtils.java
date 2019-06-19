package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.service.FlightService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ControllerUtils {
    public static void addTouristToFlight(FlightService flightService, int touristId, int flightId) {
        try {
            flightService.addTourist(flightId, touristId);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The tourist is already signed for the flight");
        }
    }
}
