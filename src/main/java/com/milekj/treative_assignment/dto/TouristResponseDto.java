package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.entity.Gender;
import com.milekj.treative_assignment.entity.Tourist;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TouristResponseDto extends TouristRequestDto{
    private long id;
    private List<Long> flightsIds;

    public TouristResponseDto(Tourist tourist) {
        firstName = tourist.getFirstName();
        lastName = tourist.getLastName();
        gender = tourist.getGender();
        country = tourist.getCountry();
        notes = tourist.getNotes();
        dateOfBirth = tourist.getDateOfBirth();
        id = tourist.getId();
        flightsIds = tourist.getFlights()
                .stream()
                .map(Flight::getId)
                .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public List<Long> getFlightsIds() {
        return flightsIds;
    }
}
