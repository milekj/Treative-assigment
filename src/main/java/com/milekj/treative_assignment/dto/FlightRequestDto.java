package com.milekj.treative_assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
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

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
        refreshDatesValid();
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        System.out.println(arrivalDateTime);
        this.arrivalDateTime = arrivalDateTime;
        refreshDatesValid();
        System.out.println(arrivalDateTime);
    }

    public int getPlacesNumber() {
        return placesNumber;
    }

    public void setPlacesNumber(int placesNumber) {
        this.placesNumber = placesNumber;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isDatesValid() {
        return datesValid;
    }

    private void refreshDatesValid() {
        datesValid = departureDateTime != null &&
                arrivalDateTime != null &&
                departureDateTime.isBefore(arrivalDateTime);
    }
}
