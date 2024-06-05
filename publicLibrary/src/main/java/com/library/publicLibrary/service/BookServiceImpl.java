package com.library.publicLibrary.service;

import com.library.publicLibrary.form.BookInput;
import com.library.publicLibrary.model.Book;
import com.library.publicLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;
    @Override
    public Book addBook(BookInput bookInput) {
        Book books = new Book();
        books.setAuthor(bookInput.getAuthor());
        books.setAvailable(bookInput.isAvailable());
        books.setGenre(bookInput.getGenre());
        books.setTitle(bookInput.getTitle());
        return bookRepository.save(books);

    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.getBookId(bookId);
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(BookInput bookInput,Long bookId) {
        Optional<Book> bookById = bookRepository.findById(bookId);
        if(bookById.isPresent()){
            Book book = bookById.get();
            book.setTitle(bookInput.getTitle());
            book.setAuthor(bookInput.getAuthor());
            book.setGenre(bookInput.getGenre());
           // book.setAvailable(bookInput.isAvailable());
            return bookRepository.save(book);
        }else{
            throw  new RuntimeException("Book with Id "+bookId +" not found");
        }

    }

    @Override
    public String deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
        return "DeletedSuccesfully";
    }
}
