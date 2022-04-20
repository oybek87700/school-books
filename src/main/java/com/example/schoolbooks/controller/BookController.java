package com.example.schoolbooks.controller;

import com.example.schoolbooks.dto.ApiResponse;
import com.example.schoolbooks.dto.BookDTO;
import com.example.schoolbooks.dto.SaveBookDTO;
import com.example.schoolbooks.entity.Book;
import com.example.schoolbooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse all = bookService.getAll();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse one = bookService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(one);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody BookDTO bookDTO) {
        ApiResponse add = bookService.add(bookDTO);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(add);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody BookDTO bookDTO) {

        ApiResponse edit = bookService.edit(id, bookDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(edit);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = bookService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(delete);
    }

}
