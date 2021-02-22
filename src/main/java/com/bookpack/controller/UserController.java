package com.bookpack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookpack.entity.User;
import com.bookpack.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user/saveAll")
	public List<User> saveAll(@RequestBody List<User> users ) {
		return userRepository.saveAll(users);
	}
	@GetMapping("/user/find/{id}")
	public Optional<User> find(@PathVariable int id) {
		return userRepository.findById(id);
	}
	@GetMapping("/user/findAll")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@PutMapping("/user/update/{id}")
	public User updateById(@RequestBody User user) {
		return userRepository.save(user);
	}	
	
	@DeleteMapping("/user/delete")
	public User deleteById(@RequestBody User user) {
		return userRepository.save(user);
	}	

}
