package com.qsoft.bankaccountdao.business;

import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public interface TransactionService {
    public TransactionEntity createTransaction(String accountNumber, double amount, String description);
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber);
    public List<TransactionEntity> getTransactionsOccurredOnTime(String accountNumber, long startTime, long endTime);
    public List<TransactionEntity> getTransactionsOccurredLastest(String accountNumber, int m);
}
