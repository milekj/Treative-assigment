package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.TouristDto;
import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TouristServiceImpl implements TouristService {
    private TouristRepository touristRepository;

    @Autowired
    public TouristServiceImpl(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tourist> getAll() {
        return touristRepository.findAll();
    }

    @Override
    @Transactional
    public Tourist create(TouristDto touristDto) {
        Tourist tourist = touristDto.toTourist();
        return touristRepository.save(tourist);
    }

    @Override
    @Transactional
    public void deleteById(long id) throws ResourceNotFoundException {
        try {
            touristRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void update(long id, TouristDto touristDto) throws ResourceNotFoundException {
        try {
            Tourist newTourist = touristDto.toTourist();
            Tourist oldTourist = touristRepository.getOne(id);
            long oldId = oldTourist.getId();
            List<Flight> oldFlights = oldTourist.getFlights();
            newTourist.setId(oldId);
            newTourist.getFlights().addAll(oldFlights);
            touristRepository.save(newTourist);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}
