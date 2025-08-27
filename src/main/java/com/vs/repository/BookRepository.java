package com.vs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByStatus(String status);
}
