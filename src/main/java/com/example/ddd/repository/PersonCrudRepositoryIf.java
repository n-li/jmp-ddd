package com.example.ddd.repository;


import com.example.ddd.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepositoryIf extends CrudRepository<Person, Integer>{
}
