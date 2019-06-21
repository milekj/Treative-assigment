package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.TouristRequestDto;
import com.milekj.treative_assignment.dto.TouristResponseDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristServiceImpl implements TouristService {
    private TouristRepository touristRepository;
    private FlightService flightService;

    @Autowired
    public TouristServiceImpl(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }
    //FlightService injected by setter to avoid circular dependency

    @Override
    @Transactional(readOnly = true)
    public List<TouristResponseDto> getAll() {
        List<Tourist> tourists = touristRepository.findAll();
        return toTouristResponseDto(tourists);
    }


    @Override
    public TouristResponseDto getDtoById(long id) throws ResourceNotFoundException {
        Tourist tourist = getById(id);
        return new TouristResponseDto(tourist);
    }

    @Override
    public List<TouristResponseDto> getByFlightId(long id) throws ResourceNotFoundException {
        Flight flight = flightService.getById(id);
        List<Tourist> tourists = flight.getTourists();
        return toTouristResponseDto(tourists);
    }

    @Override
    @Transactional
    public TouristResponseDto create(TouristRequestDto touristRequestDto) {
        Tourist tourist = touristRequestDto.toTourist();
        tourist = touristRepository.save(tourist);
        return new TouristResponseDto(tourist);
    }

    @Override
    @Transactional
    public void deleteById(long id) throws ResourceNotFoundException {
        try {
            touristRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    @Transactional
    public void update(long id, TouristRequestDto touristRequestDto) throws ResourceNotFoundException {
            Tourist newTourist = touristRequestDto.toTourist();
            Tourist oldTourist = getById(id);
            long oldId = oldTourist.getId();
            List<Flight> oldFlights = oldTourist.getFlights();
            newTourist.setId(oldId);
            newTourist.getFlights().addAll(oldFlights);
            touristRepository.save(newTourist);
    }

    @Override
    @Transactional(readOnly = true)
    public Tourist getById(long id) throws ResourceNotFoundException {
        return touristRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    private List<TouristResponseDto> toTouristResponseDto(List<Tourist> tourists) {
        return tourists.stream()
                .map(TouristResponseDto::new)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }
}
