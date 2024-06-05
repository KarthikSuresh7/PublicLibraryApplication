package com.library.publicLibrary.service;

import com.library.publicLibrary.form.BookInput;
import com.library.publicLibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book addBook(BookInput bookInput);

    Book findBookById(Long bookId);

    List<Book> findAllBook();

    Book updateBook(BookInput bookInput,Long bookId);

    String deleteById(Long bookId);
}
