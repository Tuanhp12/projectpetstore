package com.main.project.service;

import com.main.project.entity.Accounts;
import com.main.project.entity.Categories;
import com.main.project.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public List<Accounts> findAll() {
        log.debug("Request to get all Categories");
        return accountRepository.findAll();
    }
}
