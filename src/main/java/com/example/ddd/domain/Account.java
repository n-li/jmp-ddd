package com.example.ddd.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Account {

    @Id
    private String number;

    private double availableAmount;

    @OneToMany
    private List<Transaction> transactions;

    public String getNumber() {
        return number;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
