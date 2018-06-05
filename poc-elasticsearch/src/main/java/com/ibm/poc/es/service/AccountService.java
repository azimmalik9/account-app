package com.ibm.poc.es.service;

import com.ibm.poc.es.model.Account;

import java.util.List;

/**
 * Created by satish on 04/06/2018.
 */
public interface AccountService {

    List<Account> findByFirstname(String firstname);

}
