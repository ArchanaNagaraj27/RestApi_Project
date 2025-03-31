package com.example.demo1.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long userid;
    private String username;
    private Long phone;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Event> eventlist = new ArrayList<>();

    

public User() {
    }
public User(Long userid, String username, Long phone, String role) {
        this.userid = userid;
        this.username = username;
        this.phone = phone;
        this.role = role;
}
    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public List<Event> getEventlist() {
        return eventlist;
    }
    public void setEventlist(List<Event> eventlist) {
        this.eventlist = eventlist;
    }
}
