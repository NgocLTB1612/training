package com.bookpack.jpamethod;

public class BookCustomRes2 {
	String bookName;
	String categoryName;
	
	public BookCustomRes2() {
		super();
	}

	public BookCustomRes2(String bookName, String categoryName) {
		super();
		this.bookName = bookName;
		this.categoryName = categoryName;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
