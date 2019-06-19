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
        return flightRepository.findAll()
                .stream()
                .map(FlightResponseDto::new)
                .collect(Collectors.toList());
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
            newFlight.getTourists().addAll(oldTourists);
            flightRepository.save(newFlight);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addTourist(long flightId, long touristId) throws ResourceNotFoundException {
        Flight flight = getFlightByIdOrThrow(flightId);
        Tourist tourist = touristService.getTouristByIdOrThrow(touristId);
        int bookedPlacesNumber = flightRepository.getBookedPlacesNumber(flightId);
        int totalPlacesNumber = flight.getPlacesNumber();
        int freePlacesNumber = totalPlacesNumber - bookedPlacesNumber;
        if (freePlacesNumber > 0)
            flight.addToTourists(tourist);
    }

    @Override
    @Transactional(readOnly = true)
    public Flight getFlightByIdOrThrow(long id) throws ResourceNotFoundException {
        return flightRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
