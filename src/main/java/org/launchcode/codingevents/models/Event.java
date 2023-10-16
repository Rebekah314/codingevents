package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;
    @Size(max = 500, message = "Description is too long.")
    private String description;
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location is required.")
    private String location;

    @AssertTrue(message = "RSVP is required.")
    private boolean needRSVP;

    @Positive(message = "At least one participant is required.")
    private int numberAttending;


    public Event(String name, String description, String contactEmail,
                 String location, boolean needRSVP, int numberAttending) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.needRSVP = needRSVP;
        this.numberAttending = numberAttending;
        this.id = nextId;
        nextId++;
    }
    public Event(){
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isNeedRSVP() {
        return needRSVP;
    }

    public void setNeedRSVP(boolean needRSVP) {
        this.needRSVP = needRSVP;
    }

    public int getNumberAttending() {
        return numberAttending;
    }

    public void setNumberAttending(Integer numberAttending) {
        this.numberAttending = numberAttending;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return this.getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
