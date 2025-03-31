package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Entity.Vendor;
import com.example.demo1.Repository.VendorRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendorService {
    @Autowired
    VendorRepo vendorRepo;

    public Vendor addVendor(Vendor vendor)
    {
        return vendorRepo.save(vendor);
    }
    public List<Vendor> viewVendor()
    {
        return vendorRepo.findAll();
    }

    public void deleteVendor(Long vendorid)
    {
        if (vendorRepo.existsById(vendorid)){
            vendorRepo.deleteById(vendorid);
        }
        else
        {
            throw new EntityNotFoundException("Organizer Not Found");
        }
    }

    public Vendor updateVendor(Long vendorid, Vendor vendorDetails)
    {
        Vendor existingVendor = vendorRepo.findById(vendorid)
           .orElseThrow(() -> new EntityNotFoundException("Vendor with Id"+ vendorid +" not found"));

           existingVendor.setVendorid(vendorid);
           existingVendor.setVendorid(vendorDetails.getVendorid());
           existingVendor.setVendorname(vendorDetails.getVendorname());
           existingVendor.setVendorphone(vendorDetails.getVendorphone());
           existingVendor.setEventid(vendorDetails.getEventid());

           return vendorRepo.save(existingVendor);

    }


}
