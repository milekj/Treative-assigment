package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.FlightRequestDto;
import com.milekj.treative_assignment.dto.FlightResponseDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.InvalidPlacesNumberException;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;
    private TouristService touristService;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, TouristService touristService) {
        this.flightRepository = flightRepository;
        this.touristService = touristService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlightResponseDto> getAll() {
        List<Flight> flights = flightRepository.findAll();
        return toFlightResponse(flights);
    }

    @Override
    public FlightResponseDto getById(long id) throws ResourceNotFoundException {
        Flight flight = getFlightById(id);
        return new FlightResponseDto(flight);
    }

    @Override
    public List<FlightResponseDto> getByTouristId(long id) throws ResourceNotFoundException {
        Tourist tourist = touristService.getById(id);
        List<Flight> flights = tourist.getFlights();
        return toFlightResponse(flights);
    }

    @Override
    @Transactional
    public FlightResponseDto create(FlightRequestDto flightRequestDto) {
        Flight flight = flightRequestDto.toFlight();
        flight = flightRepository.save(flight);
        return new FlightResponseDto(flight);
    }

    @Override
    @Transactional
    public void deleteById(long id) throws ResourceNotFoundException {
        try {
            flightRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void update(long id, FlightRequestDto flightRequestDto) throws ResourceNotFoundException, InvalidPlacesNumberException {
            Flight newFlight = flightRequestDto.toFlight();
            Flight oldFlight = flightRepository.findById(id)
                    .orElseThrow(ResourceNotFoundException::new);
            long oldId = oldFlight.getId();
            int newPlacesNumber = newFlight.getPlacesNumber();
            int occupiedPlacesNumber = flightRepository.getBookedPlacesNumber(oldId);
            if (newPlacesNumber < occupiedPlacesNumber)
                throw new InvalidPlacesNumberException();
            List<Tourist> oldTourists = oldFlight.getTourists();
            newFlight.setId(oldId);
            System.out.println(newFlight.getTourists());
            System.out.println(oldFlight.getTourists());
            newFlight.getTourists().addAll(oldTourists);
            flightRepository.save(newFlight);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addTourist(long flightId, long touristId) throws ResourceNotFoundException, InvalidPlacesNumberException {
        Flight flight = getFlightById(flightId);
        Tourist tourist = touristService.getById(touristId);
        int bookedPlacesNumber = flightRepository.getBookedPlacesNumber(flightId);
        int totalPlacesNumber = flight.getPlacesNumber();
        int freePlacesNumber = totalPlacesNumber - bookedPlacesNumber;
        if (freePlacesNumber > 0)
            flight.addToTourists(tourist);
        else
            throw new InvalidPlacesNumberException();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteTourist(long flightId, long touristId) throws ResourceNotFoundException {
        Flight flight = getFlightById(flightId);
        Tourist tourist = touristService.getById(touristId);
        flight.removeFromTourists(tourist);
    }

    @Transactional(readOnly = true)
    public Flight getFlightById(long id) throws ResourceNotFoundException {
        return flightRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    private List<FlightResponseDto> toFlightResponse(List<Flight> flights) {
        return flights.stream()
                .map(FlightResponseDto::new)
                .collect(Collectors.toList());
    }
}
