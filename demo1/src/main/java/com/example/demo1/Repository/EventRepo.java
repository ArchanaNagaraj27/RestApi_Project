package com.example.demo1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo1.Entity.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Long>{
    
    @Query("SELECT e FROM Event e WHERE e.eventname= :name")
    List<Event> findbyname(@Param("name") String name);
    List<Event> findByeventloc(String eventLoc);
  
}