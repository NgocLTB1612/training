package com.bookpack.service;

import com.bookpack.entity.Book;
import com.bookpack.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;


public class BookService {
    @Autowired
    private BookRepository bookRepository;
    Pageable requestedPage = (Pageable) PageRequest.of(0, 15);
    Page<Book> books  = bookRepository.findAll((org.springframework.data.domain.Pageable) requestedPage);

}

