package com.bookpack.entity;

import javax.persistence.*;

import com.bookpack.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table( name = "book")
public class Book extends Auditable<String> {
	

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int bid;
	@Column(nullable = false)
	private String publisherName;
	@Column(nullable = false)
	private String authorName;
	@Column(nullable = false)
	private String bookName;
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@JsonIgnoreProperties({"books"})
	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cag_id")
	private Category category;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
