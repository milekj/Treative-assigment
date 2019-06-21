package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.dto.FlightResponseDto;
import com.milekj.treative_assignment.dto.TouristRequestDto;
import com.milekj.treative_assignment.dto.TouristResponseDto;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.service.FlightService;
import com.milekj.treative_assignment.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tourists")
@CrossOrigin
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

    @GetMapping("{id}")
    public TouristResponseDto getAll(@PathVariable long id) {
        try {
            return touristService.getDtoById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}/flights")
    public List<FlightResponseDto> getTouristFlights(@PathVariable long id) {
        try {
            return flightService.getByTouristId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public TouristResponseDto create(@RequestBody @Valid TouristRequestDto touristRequestDto, BindingResult result) {
        if (result.hasErrors())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
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
    public void updateById(@PathVariable long id,
                           @RequestBody @Valid TouristRequestDto touristRequestDto,
                           BindingResult result) {
        if (result.hasErrors())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
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
