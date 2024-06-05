package com.library.publicLibrary.controller;

import com.library.publicLibrary.model.BorrowRecord;
import com.library.publicLibrary.repository.BorrowRecordRepository;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
public class SchedulerController {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private EmailController emailController;


   @PostMapping("/mails")
  //  @Scheduled(cron = "0 0 8 * * ?")//Job runs everyday at 8am
//    At the 0th second,
//    At the 0th minute,
//    At the 8th hour (8 AM),
//    Every day of the month,
//    Every month,
//    No specific day of the week.
    public void sendReminder() throws MessagingException {
        List<BorrowRecord> allrecords = borrowRecordRepository.findAll();

        for(BorrowRecord b : allrecords){
            String email = b.getUser().getEmail();
            log.info("weeks: "+b.getDueDate().minusWeeks(2));
            if(b.getDueDate().isEqual(LocalDate.now())){
                //sendmail
                emailController.sendDueReminder(b,email);

            } else if (b.getDueDate().minusWeeks(2).isEqual(LocalDate.now())) {
                //sendreminder
                emailController.sendPreviousReminder(b,email);
            }
        }
    }
}
