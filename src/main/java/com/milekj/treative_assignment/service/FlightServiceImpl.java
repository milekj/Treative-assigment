package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.FlightDto;
import com.milekj.treative_assignment.dto.TouristDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    @Transactional
    public Flight create(FlightDto flightDto) {
        Flight flight = flightDto.toFlight();
        return flightRepository.save(flight);
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
    @Transactional
    public void update(long id, FlightDto flightDto) throws ResourceNotFoundException {
        try {
            Flight newFlight = flightDto.toFlight();
            Flight oldFlight = flightRepository.getOne(id);
            long oldId = oldFlight.getId();
            List<Tourist> oldTourists = oldFlight.getTourists();
            newFlight.setId(oldId);
            newFlight.getTourists().addAll(oldTourists);
            flightRepository.save(newFlight);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}
