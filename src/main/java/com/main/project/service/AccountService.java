package com.main.project.service;

import com.main.project.entity.Accounts;
import com.main.project.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

//    public Accounts account(){
//        return Ac
//    }
}
