package com.bookpack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookpack.entity.Book;
import com.bookpack.entity.Category;
import com.bookpack.jpamethod.CagRequest;
import com.bookpack.jpamethod.CagResponse;
import com.bookpack.repository.BookRepository;
import com.bookpack.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class CagController {

	@Autowired
	private CategoryRepository categoryRepository;

	@SuppressWarnings("unused")
	@Autowired
	private BookRepository bookRepository;

	//Save Categories 
	@PostMapping("/saveCag")
	public Category saveCag(@RequestBody CagRequest request) {
		return categoryRepository.save(request.getCategory());
	}
	
	//Find Categories by CID
	@GetMapping("/findCag/{cid}")
	public Optional<Category> findCag(@PathVariable int cid) {
		return categoryRepository.findById(cid);
	}
	
	@GetMapping("/findCag")
	public List<Category> findCag() {
		return categoryRepository.findAll();
	}
	
	//Update Categories by CID
	@PutMapping("/updateCag/{cid}")
	public Category updateCag(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	
	


}
