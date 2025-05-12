package com.ironhack.Lab308Relationships202302.model.nurse;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL)
    private List<Chapter> chapters = new ArrayList<>();

    public Association() {
    }

    public Association(Long id, List<Chapter> chapters) {
        this.id = id;
        this.chapters = chapters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", chapters=" + chapters +
                '}';
    }
}
