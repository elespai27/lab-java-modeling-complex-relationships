package com.ironhack.Lab308Relationships202302.model.nurse;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chapterId;

    private String name;
    private String district;

    @OneToOne  // Assuming one president per chapter
    @JoinColumn(name = "president_member_id")
    private Member president;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    private List<Member> members;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;

    public Chapter() {
    }

    public Chapter(Long chapterId, String name, String district, Member president, List<Member> members, Association association) {
        this.chapterId = chapterId;
        this.name = name;
        this.district = district;
        this.president = president;
        this.members = members;
        this.association = association;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        if (!this.members.contains(president)) {
            throw new IllegalArgumentException("The President have to be the member of this chapter");
        }
        this.president = president;
        president.setChapter(this);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId=" + chapterId +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", president=" + president +
                ", members=" + members +
                '}';
    }
}
