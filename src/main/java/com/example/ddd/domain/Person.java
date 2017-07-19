package com.example.ddd.domain;

import com.example.ddd.BeanUtil;
import com.example.ddd.repository.AccountCrudRepositoryIf;
import com.example.ddd.repository.PersonCrudRepositoryIf;
import com.example.ddd.repository.TransactionRepositoryIf;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personID;

    private String name;

    @OneToMany
    private List<Account> accounts;

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void saveOrCreate() {
        BeanUtil.getBean(PersonCrudRepositoryIf.class).save(this);
    }

    public void createAccount(String number) {
        Account account = new Account();
        account.setNumber(number);
        accounts.add(account);
        BeanUtil.getBean(AccountCrudRepositoryIf.class).save(account);
        BeanUtil.getBean(PersonCrudRepositoryIf.class).save(this);
    }

    public void putMoney(double amount, String accountNumber) {
        Account account  = getAccount(accountNumber);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionDate(new Date());
        BeanUtil.getBean(TransactionRepositoryIf.class).save(transaction);
        account.getTransactions().add(transaction);
        account.setAvailableAmount(account.getAvailableAmount() + amount);
        BeanUtil.getBean(PersonCrudRepositoryIf.class).save(this);
    }

    public Account getAccount(String accountNumber){
        Account account  = null;
        for (Account personAccount: accounts) {
            if (personAccount.getNumber().equals(accountNumber)) {
                account = personAccount;
            }
        }
        return account;
    }



}
