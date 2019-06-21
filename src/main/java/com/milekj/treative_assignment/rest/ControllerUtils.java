package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.exception.InvalidPlacesNumberException;
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
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The tourist is already signed for the flight");
        } catch (InvalidPlacesNumberException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There are no places left for the flight");
        }
    }

    public static void removeTouristFromFlight(FlightService flightService, int touristId, int flightId) {
        try {
            flightService.deleteTourist(flightId, touristId);
        } catch (ResourceNotFoundException e) {
            //because delete should be idempotent
        }
    }
}
