package com.library.publicLibrary.controller;

import com.library.publicLibrary.form.EmailRequestForm;
import com.library.publicLibrary.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send/{toMail}")
    private String sendSampleMail (@PathVariable String toMail, @RequestBody EmailRequestForm emailForm){
        emailSenderService.sendEmail(toMail,emailForm);
        return  "Mail triggered successfully";
    }
}
