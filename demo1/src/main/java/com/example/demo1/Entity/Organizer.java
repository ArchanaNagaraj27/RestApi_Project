package com.example.demo1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgid;
    private String orgname;
    private Long orgphone;
    private String compname;

    public Organizer()
    {
        
    }
    public Organizer(Long orgid, String orgname, Long orgphone, String compname) {
        this.orgid = orgid;
        this.orgname = orgname;
        this.orgphone = orgphone;
        this.compname = compname;
    }
    public Long getOrgid() {
        return orgid;
    }
    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }
    public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
    public Long getOrgphone() {
        return orgphone;
    }
    public void setOrgphone(Long orgphone) {
        this.orgphone = orgphone;
    }
    public String getCompname() {
        return compname;
    }
    public void setCompname(String compname) {
        this.compname = compname;
    }
}

