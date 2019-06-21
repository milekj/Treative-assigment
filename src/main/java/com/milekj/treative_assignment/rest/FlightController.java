package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.dto.FlightRequestDto;
import com.milekj.treative_assignment.dto.FlightResponseDto;
import com.milekj.treative_assignment.dto.TouristResponseDto;
import com.milekj.treative_assignment.exception.InvalidPlacesNumberException;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.service.FlightService;
import com.milekj.treative_assignment.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin
public class FlightController {
    private FlightService flightService;
    private TouristService touristService;

    @Autowired
    public FlightController(FlightService flightService, TouristService touristService) {
        this.flightService = flightService;
        this.touristService = touristService;
    }

    @GetMapping("")
    public List<FlightResponseDto> getAll() {
        return flightService.getAll();
    }

    @GetMapping("{id}")
    public FlightResponseDto getAll(@PathVariable long id) {
        try {
            return flightService.getDtoById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}/tourists")
    public List<TouristResponseDto> getTourists(@PathVariable long id) {
        try {
            return touristService.getByFlightId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public FlightResponseDto create(@RequestBody FlightRequestDto flightRequestDto) {
        return flightService.create(flightRequestDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        try {
            flightService.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable long id, @RequestBody FlightRequestDto flightRequestDto) {
        try {
            flightService.update(id, flightRequestDto);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (InvalidPlacesNumberException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "New places number is lower than current occupied places number");
        }
    }

    @PostMapping("{flightId}/tourists/{touristId}")
    public void addTourist(@PathVariable int touristId, @PathVariable int flightId) {
        ControllerUtils.addTouristToFlight(flightService, touristId, flightId);
    }

    @DeleteMapping("{flightId}/tourists/{touristId}")
    public void deleteTourist(@PathVariable int touristId, @PathVariable int flightId) {
        ControllerUtils.removeTouristFromFlight(flightService, touristId, flightId);
    }
}
