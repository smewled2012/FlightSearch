package com.example.demo.accountRepository;

import com.example.demo.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Long> {

    List<Account> findAllByAccountNumber(String searchfor);
    Double countAllByAccountNumber(String search);

}
