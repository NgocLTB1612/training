package com.bookpack.jpamethod;

public class BookByBookName {
    String bookName;
    String authorName;
    String publisherName;


    public BookByBookName(String bookName, String authorName, String publisherName) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }


}
