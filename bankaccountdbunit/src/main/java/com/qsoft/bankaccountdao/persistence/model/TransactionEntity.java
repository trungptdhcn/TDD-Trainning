package com.qsoft.bankaccountdao.persistence.model;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class TransactionEntity {
    private long timeStamp;
    private String accountNumber;
    private String description;
    private double amount;
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
}
