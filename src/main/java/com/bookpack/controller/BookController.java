package com.bookpack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpack.entity.Book;
import com.bookpack.jpamethod.BookCustomRes;
import com.bookpack.jpamethod.BookCustomRes2;
import com.bookpack.repository.BookRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/test")
	public List<Book> test(@RequestParam(name = "name", defaultValue = "") String name) {
		return bookRepository.findBook();
	}
	
	@GetMapping("/test2")
	public List<BookCustomRes> test2(@RequestParam(name = "name", defaultValue = "") String name) {
		return bookRepository.findBook2();
	}

	@GetMapping("/test3")
	public List<BookCustomRes2> test3(@RequestParam(name = "name", defaultValue = "") String name) {
		//Begin transaction
//		try {
//          save to table a
//			save to table b
//
//			save to table c
//			transaction.commit(...);
//		}catch(Exception ex) {
//			transaction.rollBack(...);
//		}
		
		return bookRepository.findBook3();
	}
	
	@GetMapping("/api/v1/test")
	public String getStatusMessage(@RequestParam String message) {
		return message;
	}

	@PostMapping("/book")
	public Book save(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PostMapping("/books")
	public List<Book> saveAll(@RequestBody List<Book> books) {
		return bookRepository.saveAll(books);
	}

	@GetMapping("/book/{bid}")
	public Optional<Book> find(@PathVariable int bid) {
		return bookRepository.findById(bid);
	}

	@GetMapping("/book")
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/book")
	public Book updateById(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/book/{bid}")
	public Integer deleteById(@PathVariable(name = "bid") Integer id ){
		bookRepository.deleteById(id);
		return id;
	}

	@GetMapping("/findAllAsc")

	public List<Book> findAllOrderByNameAsc() {
		return bookRepository.findAllByOrderByBookNameAsc();

	}

}
