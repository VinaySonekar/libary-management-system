package com.vs.service;

import java.util.List;

import com.vs.dto.BookDto;
import com.vs.entity.Book;
import com.vs.util.BookNotFoundException;

public interface BookService {

    Book add(BookDto bookDto);
    List<Book> list();
    Book fetch(int bookId) throws BookNotFoundException;
    void delete(int bookId) throws BookNotFoundException;
    void update(Book book, int bookId) throws BookNotFoundException;
	void updateStatusToAvailable( int bookId) throws BookNotFoundException;
	void updateStatusToBorrowed( int bookId) throws BookNotFoundException;
	List<Book> findByBookStatus(String status);

}
