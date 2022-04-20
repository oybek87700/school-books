package com.example.schoolbooks.service;

import com.example.schoolbooks.dto.ApiResponse;
import com.example.schoolbooks.dto.BookDTO;
import com.example.schoolbooks.dto.SaveBookDTO;
import com.example.schoolbooks.entity.Book;
import com.example.schoolbooks.entity.SaveBook;
import com.example.schoolbooks.repository.BookRepository;
import com.example.schoolbooks.repository.SaveBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    SaveBookRepository savebookRepository;

    public ApiResponse getAll() {
        List<Book> all = bookRepository.findAll();
        return new ApiResponse("Mana", true, all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
            return new ApiResponse("Mana", true, byId.get());
        }
        return new ApiResponse("ERROR", false);
    }

    public ApiResponse add(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookName(bookDTO.getBookName());
        book.setClassNum(bookDTO.getClassNum());
        book.setLang(bookDTO.getLang());
        book.setInfo(bookDTO.getInfo());
        book.setPhoto(bookDTO.getPhoto());
        Book save = bookRepository.save(book);
        return new ApiResponse("ADDED", true, save);
    }

    public ApiResponse edit(Integer id, BookDTO bookDTO) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
            Book book = byId.get();
            book.setBookName(bookDTO.getBookName());
            book.setClassNum(bookDTO.getClassNum());
            book.setLang(bookDTO.getLang());
            book.setInfo(bookDTO.getInfo());
            book.setPhoto(bookDTO.getPhoto());
            Book save = bookRepository.save(book);
            return new ApiResponse("EDITED", true, save);
        }
        return new ApiResponse("ERROR", false);
    }

    public ApiResponse delete(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
            bookRepository.deleteById(id);
            return new ApiResponse("DELETED", true);
        }
        return new ApiResponse("ERROR", false);
    }


}
