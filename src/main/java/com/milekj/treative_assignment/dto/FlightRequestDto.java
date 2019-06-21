package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Flight;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightRequestDto {
    @Future
    @NotNull
    protected LocalDateTime departureDateTime;

    @Future
    @NotNull
    protected LocalDateTime arrivalDateTime;

    @AssertTrue
    private boolean datesValid;

    @Min(1)
    protected int placesNumber;

    @DecimalMin("0.01")
    protected BigDecimal ticketPrice;

    public FlightRequestDto() {
        datesValid = false;
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

    private void refreshDatesValid() {
        datesValid = (departureDateTime != null && departureDateTime.isBefore(arrivalDateTime));
    }
}
