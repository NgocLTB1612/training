package com.bookpack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bookpack.entity.Book;
import com.bookpack.jpamethod.BookCustomRes;
import com.bookpack.jpamethod.BookCustomRes2;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// Derived Query Methods in Spring Data JPA Repositories
	List<Book> findAllByOrderByBookNameAsc();

	// Test
	@Query(value = "select b from Book b left join Category c on b.category.cid = c.cid")
	List<Book> findBook();

	//Custom res
	@Query(value = "select b from Book b left join Category c on b.category.cid = c.cid")
	List<BookCustomRes> findBook2();

	//Custom res
	@Query(value = "select new com.bookpack.jpamethod.BookCustomRes2(b.bookName,c.cag_name) from Book b left join Category c on b.category.cid = c.cid")
	List<BookCustomRes2> findBook3();
}