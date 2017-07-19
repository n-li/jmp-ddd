package com.example.ddd.repository;


import com.example.ddd.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepositoryIf extends CrudRepository<Transaction, Integer>{
}
