package com.ibm.poc.es.repository;

import com.ibm.poc.es.model.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by satish on 04/06/2018.
 */
public interface AccountRepository extends ElasticsearchRepository<Account, String> {

    List<Account> findByFirstname(String firstname);
}
