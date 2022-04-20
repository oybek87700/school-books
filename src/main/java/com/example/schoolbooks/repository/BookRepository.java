package com.example.schoolbooks.repository;

import com.example.schoolbooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
