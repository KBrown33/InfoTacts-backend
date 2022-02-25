package com.example.picgramnew.service;

import com.example.picgramnew.exceptions.InformationExistException;
import com.example.picgramnew.exceptions.InformationNotFoundException;
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
    public User updateUser(Long userId, User userObject) {
        System.out.println("service calling updateUser ==>");
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            if (userObject.getName().equals(user.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("user " + user.get().getName() + " is already exists");
            } else {
                User updateUser = userRepository.findById(userId).get();
                updateUser.setAddress(userObject.getAddress());
                updateUser.setNumber(userObject.getNumber());
                updateUser.setEmail(userObject.getEmail());
                return userRepository.save(updateUser);
            }
        } else {
            throw new InformationNotFoundException("user with id " + userId + " not found");
        }
    }

    public Optional<User> deleteUser(Long userId) {
        System.out.println("service calling deleteUser ==>");
        Optional<User> user = userRepository.findById(userId);

        if (((Optional<?>) user).isPresent()) {
            userRepository.deleteById(userId);
            return user;
        } else {
            throw new InformationNotFoundException("category with id " + userId + " not found");
        }
    }
}
//    public String deleteUsers(Long userId) {
//        userRepository.deleteById(userId);
//        return "deleted User " + userId;
//    }

