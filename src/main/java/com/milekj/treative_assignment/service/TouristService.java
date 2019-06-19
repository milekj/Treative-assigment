package com.milekj.treative_assignment.service;

import com.milekj.treative_assignment.dto.TouristRequestDto;
import com.milekj.treative_assignment.dto.TouristResponseDto;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;

import java.util.List;

public interface TouristService {
    List<TouristResponseDto> getAll();
    TouristResponseDto create(TouristRequestDto touristRequestDto);
    void deleteById(long id) throws ResourceNotFoundException;
    void update(long id, TouristRequestDto touristRequestDto) throws ResourceNotFoundException;
    Tourist getTouristByIdOrThrow(long id) throws ResourceNotFoundException;
}
