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

import com.example.demo1.Entity.User;
import com.example.demo1.Service.EventService;
import com.example.demo1.Service.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/view")
    public List<User> viewUser(){
        return userService.viewUser();
    }

    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userid){
        userService.deleteUser(userid);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/update/{userid}")
    public ResponseEntity<User> updateUser(@PathVariable Long userid, @RequestBody User userDetails)
    {
        User updatedUser=userService.updateUser(userid,userDetails);
        return ResponseEntity.ok(updatedUser);
    }
}

