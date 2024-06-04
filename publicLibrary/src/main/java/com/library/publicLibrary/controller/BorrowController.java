package com.library.publicLibrary.controller;

import com.library.publicLibrary.model.Book;
import com.library.publicLibrary.model.BorrowRecord;
import com.library.publicLibrary.model.User;
import com.library.publicLibrary.service.BookService;
import com.library.publicLibrary.service.BorrowService;
import com.library.publicLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @PostMapping("/borrowBook")
    public ResponseEntity<BorrowRecord> borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        User user = userService.findByUsersId(userId).get();
        Book book = bookService.findBookById(bookId);
        return ResponseEntity.ok(borrowService.borrowBook(user, book));
    }

}
