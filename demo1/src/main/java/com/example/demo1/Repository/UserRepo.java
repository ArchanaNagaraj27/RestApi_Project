package com.example.demo1.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.User;

public interface UserRepo extends JpaRepository<User , Long> {

}
