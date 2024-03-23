package com.example.springdatajpahibernatemapping.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tutorial_details")
public class TutorialDetails {

    @Id
    private long id;

    @Column
    private Date createdOn;

    @Column
    private String createdBy;

    //lazy option says that the data will be fetched the moment it is accessed for the first time
    @OneToOne(fetch=FetchType.LAZY)// This will work the very first ti,me connection is established
    @MapsId // when there is primary key and foreign key relationship created between two entities
    @JoinColumn(name="tutorials_id")
    private Tutorials tutorials;

    public TutorialDetails(String createdBy)
    {
        this.createdOn=new Date();
        this.createdBy=createdBy;
    }

    public TutorialDetails(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Tutorials getTutorials() {
        return tutorials;
    }

    public void setTutorials(Tutorials tutorials) {
        this.tutorials = tutorials;
    }
}
