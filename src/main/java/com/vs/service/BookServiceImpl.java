package com.vs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.dto.BookDto;
import com.vs.entity.Book;
import com.vs.mapper.BookMapper;
import com.vs.repository.BookRepository;
import com.vs.util.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;
    
    @Autowired
    private BookMapper mapper;

    @Override
    public Book add(BookDto bookDto) {
        Book book = mapper.toEntity(bookDto);
        return repository.save(book);
    }

    @Override
    public List<Book> list() {
        return repository.findAll();
    }

    @Override
    public Book fetch(int bookId) throws BookNotFoundException {
        return repository.findById(bookId).orElseThrow(() -> new BookNotFoundException("No Book record available with Id - " + bookId));
    }

    @Override
    public void delete(int bookId) throws BookNotFoundException {
        Book book = repository.findById(bookId).orElseThrow(() -> new BookNotFoundException("No Book record available with Id - " + bookId));
        repository.delete(book);
    }

    @Override
    public void update(Book book, int bookId) throws BookNotFoundException {
        Book existingBook = repository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("No Book record available with Id - " + bookId));

        mapper.updateBookFromEntity(book, existingBook);

        repository.save(existingBook);
    }

	@Override
	public void updateStatusToAvailable(int bookId) throws BookNotFoundException {
		Book existingBook = repository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("No Book record available with Id - " + bookId));
		existingBook.setStatus("Available");
		 repository.save(existingBook);
	}
	
	@Override
	public void updateStatusToBorrowed(int bookId) throws BookNotFoundException {
		Book existingBook = repository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("No Book record available with Id - " + bookId));
		existingBook.setStatus("Borrowed");
		 repository.save(existingBook);
	}

	@Override
	public List<Book> findByBookStatus(String status) {
		
		return repository.findByStatus(status);
	}

}
