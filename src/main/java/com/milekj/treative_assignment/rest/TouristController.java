package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.dto.TouristRequestDto;
import com.milekj.treative_assignment.dto.TouristResponseDto;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.service.FlightService;
import com.milekj.treative_assignment.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    private TouristService touristService;
    private FlightService flightService;

    @Autowired
    public TouristController(TouristService touristService, FlightService flightService) {
        this.touristService = touristService;
        this.flightService = flightService;
    }

    @GetMapping("")
    public List<TouristResponseDto> getAll() {
        return touristService.getAll();
    }

    @PostMapping("")
    public TouristResponseDto create(@RequestBody @Valid TouristRequestDto touristRequestDto) {
        return touristService.create(touristRequestDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        try {
            touristService.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable long id, @RequestBody TouristRequestDto touristRequestDto) {
        try {
            touristService.update(id, touristRequestDto);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("{touristId}/flights/{flightId}")
    public void addTourist(@PathVariable int touristId, @PathVariable int flightId) {
        ControllerUtils.addTouristToFlight(flightService, touristId, flightId);
    }

    @DeleteMapping("{touristId}/flights/{flightId}")
    public void deleteTourist(@PathVariable int touristId, @PathVariable int flightId) {
        ControllerUtils.removeTouristFromFlight(flightService, touristId, flightId);
    }
}
