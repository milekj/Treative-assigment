package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Flight;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightDto {
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int placesNumber;
    private BigDecimal ticketPrice;

    public FlightDto() {
    }

    public Flight toFlight() {
        Flight flight = new Flight();
        flight.setDepartureDateTime(departureDateTime);
        flight.setArrivalDateTime(arrivalDateTime);
        flight.setPlacesNumber(placesNumber);
        flight.setTicketPrice(ticketPrice);
        return flight;
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

    public static FlightDto.Builder builder() {
        return new FlightDto.Builder();
    }

    private FlightDto(LocalDateTime departureDateTime,
                      LocalDateTime arrivalDateTime,
                      int placesNumber,
                      BigDecimal ticketPrice) {
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.placesNumber = placesNumber;
        this.ticketPrice = ticketPrice;
    }

    public static class Builder {
        private LocalDateTime departureDateTime;
        private LocalDateTime arrivalDateTime;
        private int placesNumber;
        private BigDecimal ticketPrice;

        public FlightDto build() {
            return new FlightDto(departureDateTime, arrivalDateTime, placesNumber, ticketPrice);
        }

        public FlightDto.Builder setDepartureDateTime(LocalDateTime departureDateTime) {
            this.departureDateTime = departureDateTime;
            return this;
        }

        public FlightDto.Builder setArrivalDateTime(LocalDateTime arrivalDateTime) {
            this.arrivalDateTime = arrivalDateTime;
            return this;
        }

        public FlightDto.Builder setPlacesNumber(int placesNumber) {
            this.placesNumber = placesNumber;
            return this;
        }

        public FlightDto.Builder setTicketPrice(BigDecimal ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }
    }
}
