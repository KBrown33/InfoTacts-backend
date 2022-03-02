package com.example.picgramnew.controller;

import com.example.picgramnew.exceptions.InformationExistException;
import com.example.picgramnew.model.User;
import com.example.picgramnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;

    }


    @GetMapping(path = "/users/")
    public List<User> getAllUsers(          ) {
        return userService.getAllUser();
    }

    @GetMapping(path = "/users/{userId}")
    public User getUsers(@PathVariable Long userId) {
        return userService.getUsers(userId);
    }

    @PostMapping("/users/")
    public User createUsers(@RequestBody User userObject) {
        return userService.createUser(userObject);
    }

    @PutMapping("/users/{userId}/")
    public User updateUser (@PathVariable(value = "userId") Long userId, @RequestBody User
            userObject){
        return userService.updateUser(userId, userObject);


    }

    @DeleteMapping("/users/{userId}/")
    public Optional<User> deleteUser (@PathVariable(value = "userId") Long userId){

        return userService.deleteUser(userId);


    }
}


