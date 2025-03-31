package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo1.Entity.Event;
import com.example.demo1.Repository.EventRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;

    public Event addEvent(Event event)
    {
        return eventRepo.save(event);
    }

    @Transactional
    public List<Event> viewEvent()
    {
        return eventRepo.findAll();
    }

    public void deleteEvent(Long eventid)
    {
        if(eventRepo.existsById(eventid))
        {
            eventRepo.deleteById(eventid);
        }
        else{
            throw new EntityNotFoundException("Event not found");
        }
    }

    public Event updateEvent(Long eventid, Event eventDetails)
    {
        Event existingEvent = eventRepo.findById(eventid)
              .orElseThrow(() -> new EntityNotFoundException("Event with ID "+eventid +"not found"));
             eventDetails.setEventid(eventid);
             existingEvent.setEventid(eventDetails.getEventid());
             existingEvent.setEventname(eventDetails.getEventname());
             existingEvent.setEventdate(eventDetails.getEventdate());
             existingEvent.setEventloc(eventDetails.getEventloc());

             return eventRepo.save(existingEvent);

    }

    public Page<Event>getMethod(int size,int page){
        Pageable pageable = PageRequest.of(page, size);
        return eventRepo.findAll(pageable);
    }

    public List<Event> sortbyEventname(){
        return eventRepo.findAll(Sort.by(Sort.Direction.DESC,"eventname"));
    }

    public List<Event> getbyname(String name){
        return eventRepo.findbyname(name);
    }

    public List<Event> getbyloc(String eventLoc){
        return eventRepo.findByeventloc(eventLoc);
    }
}
