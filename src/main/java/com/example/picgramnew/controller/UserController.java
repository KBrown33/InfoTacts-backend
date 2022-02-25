package com.example.picgramnew.controller;

import com.example.picgramnew.exceptions.InformationExistException;
import com.example.picgramnew.model.User;
import com.example.picgramnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;

    }

    //    @GetMapping("/hello-world/")
//    public String helloWorld(){
//        return "Hello World";
//    }
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

    @PutMapping("/users/{userId}")
    public User updateUsers(@PathVariable(value = "userId") Long userId, @RequestBody User body) {
        return userService.updateUsers(userId, body);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUsers(@PathVariable(value = "userId") Long userId) {
        return userService .deleteUsers(userId);
    }
}


