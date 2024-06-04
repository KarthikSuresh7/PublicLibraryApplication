package com.library.publicLibrary.service;

import com.library.publicLibrary.form.EmailRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String toMail, EmailRequestForm emailForm) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("skarthikpec@gmail.com");
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setSubject(emailForm.getSubject());
        simpleMailMessage.setText(emailForm.getMessage());

        javaMailSender.send(simpleMailMessage);
    }
}
