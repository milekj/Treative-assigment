package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Gender;
import com.milekj.treative_assignment.entity.Tourist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class TouristRequestDto {
    @NotBlank
    protected String firstName;

    @NotBlank
    protected String lastName;

    @NotNull
    protected Gender gender;

    @NotBlank
    protected String country;

    protected String notes;

    @Past
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
