package com.library.publicLibrary.controller;

import com.library.publicLibrary.form.BookInput;
import com.library.publicLibrary.model.Book;
import com.library.publicLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody BookInput bookInput){
        return ResponseEntity.ok(bookService.addBook(bookInput));
    }

    @GetMapping("/allBook")
    public ResponseEntity<List<Book>>findAllBooks(){
        return ResponseEntity.ok(bookService.findAllBook());
    }
}
