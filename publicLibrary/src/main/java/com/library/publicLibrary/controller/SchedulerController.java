package com.library.publicLibrary.controller;

import com.library.publicLibrary.model.BorrowRecord;
import com.library.publicLibrary.repository.BorrowRecordRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SchedulerController {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private EmailController emailController;


    @PostMapping("/mails")
    public void sendReminder() throws MessagingException {
        List<BorrowRecord> allrecords = borrowRecordRepository.findAll();

        for(BorrowRecord b : allrecords){
            String email = b.getUser().getEmail();
            if(b.getDueDate().isEqual(LocalDate.now())){
                //sendmail
                emailController.sendDueReminder(b,email);
            } else if (b.getDueDate().minusWeeks(2).isEqual(LocalDate.now())) {
                //sendreminder
            }
        }
    }
}
