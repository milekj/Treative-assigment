package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Gender;
import com.milekj.treative_assignment.entity.Tourist;
import java.time.LocalDate;

public class TouristRequestDto {
    protected String firstName;
    protected String lastName;
    protected Gender gender;
    protected String country;
    protected String notes;
    protected LocalDate dateOfBirth;

    public TouristRequestDto() {
    }

    public Tourist toTourist() {
        return new Tourist(firstName, lastName, gender, country, notes, dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
