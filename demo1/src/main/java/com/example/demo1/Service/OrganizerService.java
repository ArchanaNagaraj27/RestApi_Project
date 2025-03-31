package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo1.Entity.Organizer;
import com.example.demo1.Repository.OrganizerRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrganizerService {
    @Autowired
    OrganizerRepo organizerRepo;

    public Organizer addOrganizer(Organizer organizer)
    {
        return organizerRepo.save(organizer);
    }
    public List<Organizer> viewOrganizer()
    {
        return organizerRepo.findAll();
    }

    public void deleteOrganizer(Long orgid)
    {
        if (organizerRepo.existsById(orgid)) {
            organizerRepo.deleteById(orgid);
        }
        else
        {
            throw new EntityNotFoundException("Organizer Not Found");
        }
    }

    public Organizer updateOrganizer(Long orgid, Organizer organizerDetails)
    {
        Organizer existingOrganizer = organizerRepo.findById(orgid)
           .orElseThrow(() -> new EntityNotFoundException("Organizer with Id"+ orgid +" not found"));

           organizerDetails.setOrgid(orgid);
           existingOrganizer.setOrgid(organizerDetails.getOrgid());
           existingOrganizer.setOrgname(organizerDetails.getOrgname());
           existingOrganizer.setOrgphone(organizerDetails.getOrgphone());
           existingOrganizer.setCompname(organizerDetails.getCompname());

           return organizerRepo.save(existingOrganizer);

    }
    
     public Page<Organizer>getMethod(int size,int page){
        Pageable pageable = PageRequest.of(page, size);
        return organizerRepo.findAll(pageable);
    }
    public List<Organizer> sortbyOrgName(){

        return organizerRepo.findAll(Sort.by(Sort.Direction.DESC,"orgname"));
    }

    public List<Organizer> getbyorgName(String name)
    {
        return organizerRepo.findByOrgname(name);
    }

    public List<Organizer> getbycompName(String compName)
    {
        return organizerRepo.findByCompname(compName);
    }


}
