package com.milekj.treative_assignment.dto;

import com.milekj.treative_assignment.entity.Gender;
import com.milekj.treative_assignment.entity.Tourist;

import java.time.LocalDate;

public class TouristDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String country;
    private String notes;
    private LocalDate dateOfBirth;

    public TouristDto() {
    }

    public Tourist toTourist() {
        Tourist tourist = new Tourist();
        tourist.setFirstName(firstName);
        tourist.setLastName(lastName);
        tourist.setGender(gender);
        tourist.setCountry(country);
        tourist.setNotes(notes);
        tourist.setDateOfBirth(dateOfBirth);
        return tourist;
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

    public static TouristDto.Builder builder() {
        return new TouristDto.Builder();
    }

    private TouristDto(String firstName,
                       String lastName,
                       Gender gender,
                       String country,
                       String notes,
                       LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.dateOfBirth = dateOfBirth;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Gender gender;
        private String country;
        private String notes;
        private LocalDate dateOfBirth;

        public TouristDto build() {
            return new TouristDto(firstName, lastName, gender, country, notes, dateOfBirth);
        }

        public TouristDto.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TouristDto.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TouristDto.Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public TouristDto.Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public TouristDto.Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public TouristDto.Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
    }
}
