package com.qsoft.bankaccountdao.business.Impl;

import com.qsoft.bankaccountdao.business.TransactionService;
import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
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
public class TransactionImpl implements TransactionService {
    private static TransactionDAO mockTransactionDAO;
    private static Calendar mockCalendar;

    @Override
    public TransactionEntity createTransaction(String accountNumber, double amount, String description) {
        long timeStamp = mockCalendar.getTimeInMillis();
        TransactionEntity transaction = new TransactionEntity(accountNumber,amount,timeStamp,description);
        mockTransactionDAO.save(transaction);
        return transaction;        }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return mockTransactionDAO.find(accountNumber);
    }


    @Override
    public List<TransactionEntity> getTransactionsOccurredOnTime(String accountNumber, long startTime, long endTime) {
        return mockTransactionDAO.findOneTime(accountNumber, startTime, endTime);
    }
    @Override
    public List<TransactionEntity> getTransactionsOccurredLastest(String accountNumber, int m) {
        return mockTransactionDAO.findLastest(accountNumber,m);
    }
}
