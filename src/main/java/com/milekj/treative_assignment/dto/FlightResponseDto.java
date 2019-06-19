package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Flight;
import com.milekj.treative_assignment.entity.Tourist;

import java.util.List;
import java.util.stream.Collectors;

public class FlightResponseDto extends FlightRequestDto {
    private long id;
    private List<Long> touristsIds;

    public FlightResponseDto(Flight flight) {
        departureDateTime = flight.getDepartureDateTime();
        arrivalDateTime = flight.getArrivalDateTime();
        placesNumber = flight.getPlacesNumber();
        ticketPrice = flight.getTicketPrice();
        id = flight.getId();
        touristsIds = flight.getTourists()
                .stream()
                .map(Tourist::getId)
                .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public List<Long> getTouristsIds() {
        return touristsIds;
    }
}
