package com.vs.dto;

import jakarta.validation.constraints.*;

public class BookDto {

   
    private int bookId;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title must be at most 100 characters")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Size(max = 100, message = "Author name must be at most 100 characters")
    private String author;

    @Digits(integer = 13, fraction = 0, message = "ISBN must be a valid number with up to 13 digits")
    private long isbn;

    @NotBlank(message = "Status cannot be blank")
    @Pattern(regexp = "Available|Borrowed", message = "Status must be either 'Available' or 'Borrowed'")
    private String status;

    // Getters and setters...

    

    public BookDto(int bookId, String title, String author, long isbn, String status) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

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
    
    public BookDto() {
		// TODO Auto-generated constructor stub
	}

   
}
