package com.library.publicLibrary.service;

import com.library.publicLibrary.form.EmailRequestForm;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {

    void sendEmail(String toMail, EmailRequestForm emailForm) throws MessagingException;
}
