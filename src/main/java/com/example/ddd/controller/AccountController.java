package com.example.ddd.controller;


import com.example.ddd.domain.Account;
import com.example.ddd.domain.Person;
import com.example.ddd.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {


    @Autowired
    private PersonRepository personRepository;

    @PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@RequestBody Person person) {
        person.saveOrCreate();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return personRepository.getPerson(id);
    }

    @PostMapping(value = "/person/{id}/account/{number}/create")
    public void createAccount(@PathVariable("id") int id, @PathVariable("number") String number) {
        Person person = personRepository.getPerson(id);
        person.createAccount(number);
    }

    @PostMapping(value = "/person/{id}/account/{number}/put/{amount}")
    public void putMoney(@PathVariable("id") int id, @PathVariable("number") String number,
                             @PathVariable double amount) {
        Person person = personRepository.getPerson(id);
        person.putMoney(amount, number);
    }

    @GetMapping("/person/{id}/account/{number}/history")
    public Account getAccountHistory(@PathVariable("id") int id, @PathVariable("number") String number) {
        return personRepository.getPerson(id).getAccount(number);
    }

}
