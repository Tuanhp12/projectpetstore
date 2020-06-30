package com.main.project.web;

import com.main.project.entity.Accounts;
import com.main.project.entity.Customers;
import com.main.project.service.AccountService;
import com.main.project.service.MailService;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin
public class EmailController {
    private final MailService notificationService;
    private final AccountService accountService;


    public EmailController(MailService notificationService, AccountService accountService) {
        this.notificationService = notificationService;
        this.accountService = accountService;

    }

    /**
     *
     * @return
     */
    @GetMapping("/send-mail")
    public String send() {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        Customers customer = new Customers();
        customer.setNameCustomer("TuanThanh");
        customer.setEmail("cachephp12@gmail.com"); //Receiver's email address

        /*
         * Here we will call sendEmail() for Sending mail to the sender.
         */
        try {
            notificationService.sendEmail(customer);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    /**
     *
     * @return
     * @throws MessagingException
     */
    @GetMapping("/send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        Customers customer = new Customers();
        customer.setEmail("cachephp12@gmail.com"); //Receiver's email address

        /*
         * Here we will call sendEmailWithAttachment() for Sending mail to the sender
         * that contains a attachment.
         */
        try {
            notificationService.sendEmailWithAttachment(customer);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }
}
