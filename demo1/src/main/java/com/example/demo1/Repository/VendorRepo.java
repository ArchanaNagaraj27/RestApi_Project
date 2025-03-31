package com.example.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.Vendor;

public interface VendorRepo extends JpaRepository<Vendor , Long> {

    
}

