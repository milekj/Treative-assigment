package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Flight;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightRequestDto {
    @Future
    protected LocalDateTime departureDateTime;

    @Future
    protected LocalDateTime arrivalDateTime;

    @Min(1)
    protected int placesNumber;

    @DecimalMin("0.01")
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
