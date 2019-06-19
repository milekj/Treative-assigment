package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.dto.FlightDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("")
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @PostMapping("")
    public Flight create(@RequestBody FlightDto flightDto) {
        return flightService.create(flightDto);
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
    public void updateById(@PathVariable long id, @RequestBody FlightDto flightDto) {
        try {
            flightService.update(id, flightDto);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
