package com.example.demo1.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo1.Entity.Organizer;


@Repository
public interface OrganizerRepo extends JpaRepository<Organizer , Long> {
  
  @Query("SELECT o FROM Organizer o WHERE o.orgname= :name")
  List<Organizer> findByOrgname(@Param("name") String name);

  List<Organizer> findByCompname(String compname);
}
