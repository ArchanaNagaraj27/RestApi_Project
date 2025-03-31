package com.example.demo1.Controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Entity.Organizer;
import com.example.demo1.Service.OrganizerService;

@RestController
@RequestMapping("/organizer")
public class OrganizerController 
{
    @Autowired
    OrganizerService organizerService;

    @PostMapping("/add")
    public Organizer addOrganizer(@RequestBody Organizer organizer )
    {
        return organizerService.addOrganizer(organizer);
    }

    @GetMapping("/view")
    public List<Organizer> viewOrganizer()
    {
        return organizerService.viewOrganizer();
    }

    @DeleteMapping("/delete/{orgid}")
    public ResponseEntity<String> deleteOrganizer(@PathVariable Long orgid)
    {
        organizerService.deleteOrganizer(orgid);
        return ResponseEntity.ok("Organizer deleted successfully");
    }

    @PutMapping("/update/{orgid}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long orgid ,@RequestBody Organizer organizerDetails )
    {
        Organizer updatedOrganizer=organizerService.updateOrganizer(orgid, organizerDetails);
        return ResponseEntity.ok(updatedOrganizer);
    }

     @GetMapping("/pagination")
    public Page<Organizer> getMethod(@RequestParam int page, @RequestParam int size){
        return organizerService.getMethod(size, page);
    }

    @GetMapping("/sorted")
    public List<Organizer> sortbyOrgName(){
        return organizerService.sortbyOrgName();
    }  
    

    @GetMapping("/jpql")
    public List<Organizer> getbyorgName(@RequestParam("name") String name)
    {
        return organizerService.getbyorgName(name);
    }

    @GetMapping("/custom-compname")
    public List<Organizer> getbycompName(@RequestParam("compname") String compname)
    {
        return organizerService.getbycompName(compname);
    }



    
}

