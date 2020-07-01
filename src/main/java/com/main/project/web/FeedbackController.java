package com.main.project.web;

import com.main.project.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {
    private Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    private final MailService mailService;

    public FeedbackController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/{emailCustomer}")
    public void sendFeedback(@PathVariable(value = "emailCustomer") String email, @RequestBody String feedback){

        try {
            mailService.senNotification(email, feedback);
        }catch (MailException e){
            logger.info("Error Sending Email: " + e.getMessage());
        }
    }
}