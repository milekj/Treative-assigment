package com.milekj.treative_assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int placesNumber;

    @Column(precision = 2)
    private BigDecimal ticketPrice;

    @ManyToMany(mappedBy = "flights")
    private List<Tourist> tourists;

    public Flight() {
        tourists = new LinkedList<>();
    }

    public Flight(LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime,
                  int placesNumber,
                  BigDecimal ticketPrice) {
        this();
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.placesNumber = placesNumber;
        this.ticketPrice = ticketPrice;
    }

    public void addToTourists(Tourist tourist) {
        tourists.add(tourist);
        tourist.getFlights().add(this);
    }

    public void removeFromTourists(Tourist tourist) {
        tourists.remove(tourist);
        tourist.getFlights().remove(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
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

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }
}
