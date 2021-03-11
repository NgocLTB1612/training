package com.bookpack.controller;

import java.util.*;

import com.bookpack.jpamethod.BookByBookName;
import com.bookpack.repository.BookByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping("/book")
	public Book updateById(@RequestBody Book book) {
		return bookRepository.save(book);
	}


	@DeleteMapping("/book/{bid}")
	public Integer deleteById(@PathVariable(name = "bid") Integer id ){
		bookRepository.deleteById(id);
		return id;
	}

	@GetMapping("/findAllAsc")

	public List<Book> findAllOrderByNameAsc() {
		return bookRepository.findAllByOrderByBookNameAsc();

	}

	@RequestMapping("/search")
	public List<Book> listAll(String keyword) {
		if (keyword == null) {
			return bookRepository.findAll();
		}
		if (keyword != null) {

			return bookRepository.search(keyword);
		}
		return bookRepository.findAll();
	}
//Pagination
	@GetMapping("/book")
	public ResponseEntity<Map<String, Object>> findAll(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "15") int size
	) {

		try {
			List<Book> books = new ArrayList<>();
			Pageable paging = PageRequest.of(page, size);

			Page<Book> pageTuts;
				pageTuts = bookRepository.findAll(paging);

			books = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("books", books);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/searchByCagname")
	public List<Book> search(String keyword) {
		if (keyword == null) {
			return bookRepository.findAll();
		}
		if (keyword != null) {

			return bookRepository.findByCategoryName(keyword);
		}
		return bookRepository.findAll();
	}


}
