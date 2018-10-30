package com.example.demo.servicedao;

import com.example.demo.accountRepository.AccountRepository;
import com.example.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccountSummary(String findAccountNumber)
    {
        double balance=0;

        for(Account eachAccount:accountRepository.findAllByAccountNumber(findAccountNumber)){



        }

    }
}
