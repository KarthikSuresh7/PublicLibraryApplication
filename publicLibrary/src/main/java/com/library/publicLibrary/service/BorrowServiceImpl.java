package com.library.publicLibrary.service;

import com.library.publicLibrary.model.Book;
import com.library.publicLibrary.model.BorrowRecord;
import com.library.publicLibrary.model.User;
import com.library.publicLibrary.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    public BorrowRecord borrowBook(User user, Book book){

        if(book.isAvailable()){
            BorrowRecord record = new BorrowRecord();
            record.setUser(user);
            record.setBook(book);
            record.setBorrowDate(LocalDate.now());
            record.setDueDate(LocalDate.now().plusWeeks(2));
            book.setAvailable(false);
            return borrowRecordRepository.save(record);
        }
        throw new RuntimeException("Book is not available");
    }
}
