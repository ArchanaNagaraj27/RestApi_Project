package com.example.demo1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long vendorid;
    private String vendorname;
    private Long vendorphone;
    private Long eventid;

    public Vendor()
    {
        
    }

public Vendor(Long vendorid, String vendorname, Long vendorphone, Long eventid) {
    this.vendorid = vendorid;
    this.vendorname = vendorname;
    this.vendorphone = vendorphone;
    this.eventid = eventid;
}
public Long getVendorid() {
    return vendorid;
}
public void setVendorid(Long vendorid) {
    this.vendorid = vendorid;
}
public String getVendorname() {
    return vendorname;
}
public void setVendorname(String vendorname) {
    this.vendorname = vendorname;
}
public Long getVendorphone() {
    return vendorphone;
}
public void setVendorphone(Long vendorphone) {
    this.vendorphone = vendorphone;
}
public Long getEventid() {
    return eventid;
}
public void setEventid(Long eventid) {
    this.eventid = eventid;
}
}

