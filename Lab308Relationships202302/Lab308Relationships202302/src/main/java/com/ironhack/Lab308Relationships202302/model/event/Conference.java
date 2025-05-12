package com.ironhack.Lab308Relationships202302.model.event;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conference extends Event {
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Speaker> speakerList = new ArrayList<>();

    public Conference(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    public Conference(Long eventId, LocalDate date, Integer duration, String location, String title, List<Guest> guestList, List<Speaker> speakerList) {
        super(eventId, date, duration, location, title, guestList);
        this.speakerList = speakerList;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "speakerList=" + speakerList +
                "} " + super.toString();
    }
}
