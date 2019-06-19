package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Flight;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightRequestDto {
    protected LocalDateTime departureDateTime;
    protected LocalDateTime arrivalDateTime;
    protected int placesNumber;
    protected BigDecimal ticketPrice;

    public FlightRequestDto() {
    }

    public Flight toFlight() {
        return new Flight(departureDateTime, arrivalDateTime, placesNumber, ticketPrice);
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public int getPlacesNumber() {
        return placesNumber;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }
}
