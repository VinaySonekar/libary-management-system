package com.vs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vs.dto.BookDto;
import com.vs.entity.Book;
import com.vs.service.BookService;
import com.vs.util.BookNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody BookDto bookDto) {
        Book book = service.add(bookDto);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> books = service.list();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    @GetMapping(value = "/listbystatus/{status}", produces = "application/json")
    public ResponseEntity<List<Book>> listbystatus(@PathVariable String status) {
        List<Book> books = service.findByBookStatus(status);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{bookId}", produces = "application/json")
    public ResponseEntity<Book> fetchBook(@PathVariable int bookId) throws BookNotFoundException {
        Book book = service.fetch(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) throws BookNotFoundException {
        service.delete(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/update/{bookId}", consumes = "application/json")
    public ResponseEntity<String> updateBook(@PathVariable int bookId, @RequestBody Book book) throws BookNotFoundException {
        service.update(book, bookId);
        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
    }
    
    @PutMapping(value = "/updatetoavailable/{bookId}", consumes = "application/json")
    public ResponseEntity<String> updatetoavailable(@PathVariable int bookId) throws BookNotFoundException {
        service.updateStatusToAvailable( bookId);
        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/updatetoborrowed/{bookId}", consumes = "application/json")
    public ResponseEntity<String> updatetoborrowed(@PathVariable int bookId) throws BookNotFoundException {
        service.updateStatusToBorrowed( bookId);
        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
    }
}
