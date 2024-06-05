package com.library.publicLibrary.controller;

import com.library.publicLibrary.form.EmailRequestForm;
import com.library.publicLibrary.model.BorrowRecord;
import com.library.publicLibrary.model.User;
import com.library.publicLibrary.repository.UserRepository;
import com.library.publicLibrary.service.EmailSenderService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/send/{toMail}")
//    private String sendSampleMail (@PathVariable String toMail, @RequestBody EmailRequestForm emailForm){
//        emailSenderService.sendEmail(toMail,emailForm);
//        return  "Mail triggered successfully";
//    }

    public void sendDueReminder(BorrowRecord b,String toMail) throws MessagingException {

        String username = b.getUser().getUsername();
        log.info("username");

        String subject = "Library Due Date Reminder";
        String body = "<h1>Library Due Date Reminder</h1>"
                +"<p> Dear "+username+" ,</p>"
                + "<p>This is a friendly reminder that the book titled <b>" + b.getBook().getTitle() + "</b> is due today. Please return it to the library to avoid any late fees.</p>"
                + "<p>Thank you!</p>"
                + "<p>Best regards,<br/>Your Library Team</p>";


        int i = sendMailers(toMail, subject, body);
        if(i==1){
            log.info("Mail Triggered successfully");
        }else {
            log.info("Mail not triggered");
        }


    }

    private int sendMailers(String toMail, String subject, String body) {
        int count= 0;
        try {
            EmailRequestForm em = new EmailRequestForm();
            em.setSubject(subject);
            em.setMessage(body);
            emailSenderService.sendEmail(toMail,em);
            count=1;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void sendPreviousReminder(BorrowRecord b, String email) {
        String username = b.getUser().getUsername();
        log.info("username");

        String subject = "Library Due Date Reminder";
        String body = "<h1>Library Due Date Reminder</h1>"
                +"<p> Dear "+username+" ,</p>"
                + "<p>This is a friendly reminder that the book titled <b>" + b.getBook().getTitle() + "</b> is coming in two weeks. Please return it to the library to avoid any late fees.</p>"
                + "<p>Thank you!</p>"
                + "<p>Best regards,<br/>Your Library Team</p>";

        int i = sendMailers(email, subject, body);
        if(i==1){
            log.info("Mail Triggered successfully");
        }else {
            log.info("Mail not triggered");
        }
    }
}
