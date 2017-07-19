package com.example.ddd.repository;

import com.example.ddd.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonCrudRepository {

    @Autowired
    private PersonCrudRepositoryIf personCrudRepositoryIf;

    public Person findOne(int id) {
        return personCrudRepositoryIf.findOne(id);
    }

}
