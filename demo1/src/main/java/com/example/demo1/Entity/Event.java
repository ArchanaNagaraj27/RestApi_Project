package com.example.demo1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long eventid;
    private String eventname;
    private Long eventdate;
    private String eventloc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userid")
    @JsonBackReference
    User user;
    
    public Event() {
    }
    public Event(Long eventid, String eventname, Long eventdate, String eventloc) {
        this.eventid = eventid;
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.eventloc = eventloc;
    }
    public Long getEventid() {
        return eventid;
    }
    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }
    public String getEventname() {
        return eventname;
    }
    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
    public Long getEventdate() {
        return eventdate;
    }
    public void setEventdate(Long eventdate) {
        this.eventdate = eventdate;
    }
    public String getEventloc() {
        return eventloc;
    }
    public void setEventloc(String eventloc) {
        this.eventloc = eventloc;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}


