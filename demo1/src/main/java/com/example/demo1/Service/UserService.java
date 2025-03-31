package com.example.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Entity.User;
import com.example.demo1.Repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    @Transactional
    public List<User> viewUser(){
        return userRepo.findAll();
    }

    public void deleteUser(Long userid){
        if(userRepo.existsById(userid)){
            userRepo.deleteById(userid);
        }
        else{
            throw new EntityNotFoundException("Entity not found");
        }
    }

    public User updateUser(Long userid, User userDetails)
    {
        User existingUser=userRepo.findById(userid)
            .orElseThrow(() -> new EntityNotFoundException("User with id "+ userid +" not found"));

            userDetails.setUserid(userid);
            existingUser.setUserid(userDetails.getUserid());
           existingUser.setUsername(userDetails.getUsername());
           existingUser.setPhone(userDetails.getPhone());
           existingUser.setRole(userDetails.getRole());

           return userRepo.save(existingUser);

    }


}

