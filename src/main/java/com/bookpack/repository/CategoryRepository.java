package com.bookpack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookpack.entity.Book;
import com.bookpack.entity.Category;
import com.bookpack.jpamethod.CagResponse;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}