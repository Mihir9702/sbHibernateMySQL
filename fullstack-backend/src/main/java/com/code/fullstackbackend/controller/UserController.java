package com.code.fullstackbackend.controller;

import com.code.fullstackbackend.exception.UserNotFoundException;
import com.code.fullstackbackend.model.User;
import com.code.fullstackbackend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/user")
  void createUser(@RequestBody User newUser) {
    userRepository.save(newUser);
  }

  @GetMapping("/users")
  List<User> readAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/user/{id}")
  User readUser(@PathVariable Long id) {
    return userRepository
      .findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/user/{id}")
  void updateUser(@RequestBody User newUser, @PathVariable Long id) {
    userRepository
      .findById(id)
      .map(user -> {
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        return userRepository.save(user);
      })
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) {
    if (!userRepository.existsById(id)) {
      throw new UserNotFoundException(id);
    }

    userRepository.deleteById(id);
  }
}
