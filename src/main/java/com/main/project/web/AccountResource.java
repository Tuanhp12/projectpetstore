package com.main.project.web;

import com.main.project.entity.Accounts;
import com.main.project.entity.OrderDetails;
import com.main.project.service.AccountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class AccountResource {
    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Accounts> getAllOrderDetail(){
        return accountService.findAll();
    }
}
