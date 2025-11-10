package com.vs.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Book {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int bookId;
	 private String title;
	 private String author;
	 private long isbn;
	 private String status; // Available, Borrowed


	 public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public long getIsbn() {
			return isbn;
		}
		public void setIsbn(long isbn) {
			this.isbn = isbn;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	    
	    public Book() {
			// TODO Auto-generated constructor stub
		}
		public Book(int bookId, String title, String author, long isbn, String status) {
			super();
			this.bookId = bookId;
			this.title = title;
			this.author = author;
			this.isbn = isbn;
			this.status = status;
		}
}
