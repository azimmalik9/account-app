package com.ibm.poc.es.service;

import com.ibm.poc.es.model.Account;
import com.ibm.poc.es.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by satish on 04/06/2018.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public List<Account> findByFirstname(String firstname) {
        return accountRepository.findByFirstname(firstname);
    }
}
