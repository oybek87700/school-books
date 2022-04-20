package com.example.schoolbooks.controller;

import com.example.schoolbooks.dto.ApiResponse;
import com.example.schoolbooks.dto.SaveBookDTO;
import com.example.schoolbooks.entity.Book;
import com.example.schoolbooks.service.SaveBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/savebook")
public class SaveBookController {
    @Autowired
    SaveBookService saveBookService;
    @PostMapping("/addsavebook")
    public HttpEntity<?> saveBook(Book book, @Valid @RequestBody SaveBookDTO saveBookDTO) {
        ApiResponse apiResponse = saveBookService.saveBook(book,saveBookDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }
    @GetMapping("/allsavebook")
    public HttpEntity<?> saveBook() {
        ApiResponse allSaved = saveBookService.getAllSaved();
        return ResponseEntity.status(allSaved.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(allSaved);
    }
}
