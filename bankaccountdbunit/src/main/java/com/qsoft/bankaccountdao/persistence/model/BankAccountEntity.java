package com.qsoft.bankaccountdao.persistence.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 04/07/2013
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name ="bankaccount")
public class BankAccountEntity {
    @GeneratedValue
    @Id
    @Column(name="numberaccount")
    private String accountNumber;
    @Column(name="balance")
    private double balance;
    public BankAccountEntity(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountEntity() {
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
