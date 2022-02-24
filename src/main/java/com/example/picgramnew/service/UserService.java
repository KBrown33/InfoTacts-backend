package com.example.picgramnew.service;

import com.example.picgramnew.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserService {

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    private UserRepository userRepository;


    private MessageRepository messageRepository;

    public List<User> getAllUser() {
        List<User> user = userRepository.findAll();
        return user;

    }

    public User getUsers(@PathVariable Long userId) {
        User user =  userRepository.getById(userId);
        return  user;
    }

    public User createUser(User body) {
        return userRepository.save(body);
    }

    public User updateUsers(@PathVariable(value = "userId") Long userId, @RequestBody User body) {
        User user = userRepository.getById(userId);
        user.setName(body.getName());
        return userRepository.save(user);
    }

    public String deleteUsers(@PathVariable(value = "userId") Long userId) {
        userRepository.deleteById(userId);
        return "deleted User " + userId;
    }

}
