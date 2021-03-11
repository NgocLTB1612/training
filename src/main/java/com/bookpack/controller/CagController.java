package com.bookpack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import com.bookpack.entity.Book;
import com.bookpack.entity.Category;
import com.bookpack.jpamethod.CagRequest;
import com.bookpack.jpamethod.CagResponse;
import com.bookpack.repository.BookRepository;
import com.bookpack.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CagController {

	@Autowired
	private CategoryRepository categoryRepository;

	@SuppressWarnings("unused")
	@Autowired
	private BookRepository bookRepository;

	//Save Categories 
	@PostMapping("/cag")
	public Category saveCag(@RequestBody CagRequest request) {
		return categoryRepository.save(request.getCategory());
	}
	
	//Find Categories by CID
	@GetMapping("/cag/{cid}")
	public Optional<Category> findCag(@PathVariable int cid) {
		return categoryRepository.findById(cid);
	}
	
	@GetMapping("/cag")
	public List<Category> findCag() {
		return categoryRepository.findAll();
	}
	
	//Update Categories by CID
	@PutMapping("/cag/{cid}")
	public Category updateCag(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	//search by cag_name
	@RequestMapping("/searchCag")
	public List<Category> listAll(String keyword) {
		if (keyword == null) {
			return categoryRepository.findAll();
		}
		if (keyword != null) {

			return categoryRepository.search(keyword);
		}
		return categoryRepository.findAll();
	}

}
