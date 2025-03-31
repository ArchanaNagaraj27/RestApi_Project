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

import com.example.demo1.Entity.Event;
import com.example.demo1.Service.EventService;
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event)
    {
        return eventService.addEvent(event);
    }

    @GetMapping("/view")
    public List<Event> viewEvent()
    {
        return eventService.viewEvent();
    }

    @DeleteMapping("/delete/{eventid}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventid)
    {
        eventService.deleteEvent(eventid);
        return ResponseEntity.ok("Event deleted successfully");
    }

    @PutMapping("/update/{eventid}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long eventid, @RequestBody Event eventDetails)
    {
        Event updatedEvent= eventService.updateEvent(eventid, eventDetails);
        return ResponseEntity.ok(updatedEvent);
    }

    @GetMapping("/pagination")
    public Page<Event> getMethod(@RequestParam int page, @RequestParam int size){
        return eventService.getMethod(size, page);
    }

    @GetMapping("/sorted")
    public List<Event> sortbyEventname(){
        return eventService.sortbyEventname();
    }  
    
    @GetMapping("/jpql")
    public List<Event> getbyname(@RequestParam("name") String name){
        return eventService.getbyname(name);
    }

    @GetMapping("/custom-loc")
    public List<Event> getbyloc(@RequestParam("loc") String eventLoc){
        return eventService.getbyloc(eventLoc);
    }
}
