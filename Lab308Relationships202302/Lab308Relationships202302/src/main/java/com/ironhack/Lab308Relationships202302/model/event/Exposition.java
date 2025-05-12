package com.ironhack.Lab308Relationships202302.model.event;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Exposition extends Event {
    public Exposition() {
    }

    public Exposition(Long eventId, LocalDate date, Integer duration, String location, String title, List<Guest> guestList) {
        super(eventId, date, duration, location, title, guestList);
    }


}
