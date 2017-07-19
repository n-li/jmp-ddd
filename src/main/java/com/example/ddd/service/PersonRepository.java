package com.example.ddd.service;

import com.example.ddd.domain.Person;
import com.example.ddd.repository.PersonCrudRepositoryIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonRepository {

    @Autowired
    private PersonCrudRepositoryIf personCrudRepositoryIf;

    public Person getPerson(int id) {
        return personCrudRepositoryIf.findOne(id);
    }
}
