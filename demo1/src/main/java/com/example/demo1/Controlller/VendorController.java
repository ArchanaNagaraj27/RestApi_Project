package com.example.demo1.Controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Entity.Vendor;
import com.example.demo1.Service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    VendorService vendorService;

    @PostMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return vendorService.addVendor(vendor);
    }

    @GetMapping("/view")
    public List<Vendor> viewVendor(){
        return vendorService.viewVendor();
    }

    @DeleteMapping("/delete/{vendorid}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long vendorid){
        vendorService.deleteVendor(vendorid);
        return ResponseEntity.ok("Vendor deleted successfully");
    }

    @PutMapping("/update/{vendorid}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long vendorid, @RequestBody Vendor vendorDetails)
    {
        Vendor updateVendor=vendorService.updateVendor(vendorid,vendorDetails);
        return ResponseEntity.ok(updateVendor);
    }
}

