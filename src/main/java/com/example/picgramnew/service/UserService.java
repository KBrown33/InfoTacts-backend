package com.example.picgramnew.service;

import com.example.picgramnew.exceptions.InformationExistException;
import com.example.picgramnew.model.User;
import com.example.picgramnew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        List<User> user = userRepository.findAll();
        return user;

    }

    public User getUsers(Long userId) {
        User user = (User) userRepository.getById(userId);
        return user;
    }

    public User createUser(User userObject) {
        System.out.println("calling createUser ==>");
        User user = userRepository.findByName(userObject.getName());
        if (user != null) {
            throw new InformationExistException("user with name " + user.getName() + " already exists");
        } else {
            return userRepository.save(userObject);
        }
    }

    public User updateUsers(Long userId, User body) {
        User user = (User) userRepository.getById(userId);
        return (User) userRepository.save(user);
    }

    public String deleteUsers(Long userId) {
        userRepository.deleteById(userId);
        return "deleted User " + userId;
    }
}
