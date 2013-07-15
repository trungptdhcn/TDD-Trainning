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
@SequenceGenerator(name = "bankaccount_id_sq", sequenceName = "bankaccount_id_sq", initialValue = 1, allocationSize = 1)
public class BankAccountEntity {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bankaccount_id_sq")
    @Id
    @Column(name="id")
    private Long id;
    @Column(name = "numberaccount")
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return this.accountNumber.hashCode();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if(obj instanceof BankAccountEntity)
        {
            BankAccountEntity bankAccountEntity = (BankAccountEntity)obj;
            result = (this.getAccountNumber()==bankAccountEntity.getAccountNumber() && this.getBalance() == bankAccountEntity.getBalance());
        }
        return result;
    }
}
