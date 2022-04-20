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
public class SaveBookService {
    @Autowired
    SaveBookRepository savebookRepository;
    @Autowired
    BookRepository bookRepository;

    public ApiResponse getAllSaved(){
        List<SaveBook> all = savebookRepository.findAll();
        return new ApiResponse("Mana",true,all);
    }

    public ApiResponse saveBook(Book book,SaveBookDTO saveBookDTO) {
        Integer id = saveBookDTO.getId();
        Optional<Book> byId = bookRepository.findById(id);
        Book book1 = byId.get();
        if (byId.isPresent()) {
                SaveBook savebook = new SaveBook();
                savebook.setBookName(book1.getBookName());
                savebook.setClassNum(book1.getClassNum());
                savebook.setLang(book1.getLang());
                savebook.setInfo(book1.getInfo());
                savebook.setPhoto(book1.getPhoto());
                SaveBook save = savebookRepository.save(savebook);
                return new ApiResponse("SAVED", true, save);
        }
        return new ApiResponse("ERROR",false);
    }
}
