package com.qsoft.bankaccount.persistence.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/07/2013
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "bankaccount")
public class BankAccountEntity {
    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "balance")
    private double balance;

    @Column(name = "numberaccount")
    private String accountNumber;

    public BankAccountEntity(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public BankAccountEntity() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
