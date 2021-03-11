package com.bookpack.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue
	private int cid;

	@Column(nullable = false)
	private String cag_name;

	@OneToMany(targetEntity = Book.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cag_id", referencedColumnName = "cid")
	private List<Book> books;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCag_name() {
		return cag_name;
	}

	public void setCag_name(String cag_name) {
		this.cag_name = cag_name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
