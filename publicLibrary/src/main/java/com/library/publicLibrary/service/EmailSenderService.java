package com.library.publicLibrary.service;

import com.library.publicLibrary.form.EmailRequestForm;
import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {

    void sendEmail(String toMail, EmailRequestForm emailForm);
}
