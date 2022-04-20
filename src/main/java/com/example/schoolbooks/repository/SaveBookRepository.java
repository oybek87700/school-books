package com.example.schoolbooks.repository;

import com.example.schoolbooks.entity.SaveBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveBookRepository extends JpaRepository<SaveBook,Integer> {
}
