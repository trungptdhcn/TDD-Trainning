package com.qsoft.bankaccountdao.persistence.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="transaction")
@SequenceGenerator(name = "transaction_id_sq", sequenceName = "transaction_id_sq", initialValue = 1, allocationSize = 1)
public class TransactionEntity {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_id_sq")
    @Id
    @Column(name="id")
    private int id;
    @Column(name="timestamp")
    private long timeStamp;
    @Column(name="numberaccount")
    private String accountNumber;
    @Column(name="description")
    private String description;
    @Column(name="amount")
    private double amount;

    public TransactionEntity(long timeStamp, String accountNumber, String description, double amount)
    {
        this.timeStamp = timeStamp;
        this.accountNumber = accountNumber;
        this.description = description;
        this.amount = amount;
    }

    public TransactionEntity ()
    {

    }
    public TransactionEntity(String accountNumber, double amount, long timeStamp, String description) {
        //To change body of created methods use File | Settings | File Templates.
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.description = description;
        this.accountNumber = accountNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if(obj instanceof TransactionEntity)
        {
            TransactionEntity transactionEntity = (TransactionEntity)obj;
            result = (this.getAccountNumber()==transactionEntity.getAccountNumber() && this.getAmount() == transactionEntity.getAmount()
            && this.getDescription() == transactionEntity.getDescription()&& this.getTimeStamp() == transactionEntity.getTimeStamp() );
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        return this.accountNumber.hashCode();
    }
}
