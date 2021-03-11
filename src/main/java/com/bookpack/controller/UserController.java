package com.bookpack.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookpack.entity.User;
import com.bookpack.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public User save(@RequestBody User user ) {
		return userRepository.save(user);
	}
	@GetMapping("/register/{id}")
	public Optional<User> find(@PathVariable int id) {
		return userRepository.findById(id);
	}
	@GetMapping("/register/findAll")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@PutMapping("/register/{id}")
	public User updateById(@RequestBody User user) {
		return userRepository.save(user);
	}	
	
	@DeleteMapping("/register")
	public User deleteById(@RequestBody User user) {
		return userRepository.save(user);
	}



}
