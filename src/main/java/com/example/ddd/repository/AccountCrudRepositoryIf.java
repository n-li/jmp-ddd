package com.example.ddd.repository;

import com.example.ddd.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountCrudRepositoryIf extends CrudRepository<Account, String> {
}
