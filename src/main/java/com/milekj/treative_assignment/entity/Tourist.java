package com.milekj.treative_assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private Gender gender;
    private String country;
    private String notes;
    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(name = "flight_tourist",
            joinColumns = @JoinColumn(name = "tourist_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"),
            uniqueConstraints = { @UniqueConstraint(columnNames = {"flight_id", "tourist_id"})})
    private List<Flight> flights;

    public Tourist() {
        flights = new LinkedList<>();
    }

    public Tourist(String firstName,
                   String lastName,
                   Gender gender,
                   String country,
                   String notes,
                   LocalDate dateOfBirth) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.dateOfBirth = dateOfBirth;
    }

    public void addToFlights(Flight flight) {
        flights.add(flight);
        flight.getTourists().add(this);
    }

    public void removeFromFlights(Flight flight) {
        flights.remove(flight);
        flight.getTourists().add(this);
        flight.getTourists().add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
