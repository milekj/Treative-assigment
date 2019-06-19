package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.TouristDto;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;

import java.util.List;

public interface TouristService {
    List<Tourist> getAll();
    Tourist create(TouristDto touristDto);
    void deleteById(long id) throws ResourceNotFoundException;
    void update(long id, TouristDto touristDto) throws ResourceNotFoundException;
}
