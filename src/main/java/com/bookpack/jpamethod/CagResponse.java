package com.bookpack.jpamethod;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CagResponse {

	public String getCag_name() {
		return cag_name;
	}
	public void setCag_name(String cag_name) {
		this.cag_name = cag_name;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	private String cag_name;
	private String bookName;
}
