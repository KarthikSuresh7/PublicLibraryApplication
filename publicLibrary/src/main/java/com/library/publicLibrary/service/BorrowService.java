package com.library.publicLibrary.service;

import com.library.publicLibrary.model.Book;
import com.library.publicLibrary.model.BorrowRecord;
import com.library.publicLibrary.model.User;
import com.library.publicLibrary.repository.BorrowRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface BorrowService {
     BorrowRecord borrowBook(User user, Book book);
}
