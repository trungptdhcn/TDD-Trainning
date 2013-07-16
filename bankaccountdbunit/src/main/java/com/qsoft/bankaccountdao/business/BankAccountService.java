package com.qsoft.bankaccountdao.business;

import com.qsoft.bankaccountdao.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
import com.qsoft.bankaccountdao.persistence.model.BankAccountEntity;
import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public interface BankAccountService {
    public void setDAO(BankAccountDAO mockBankAccountDAO,TransactionDAO mockTransactionDAO);
    public BankAccountEntity openAccount(String accountNumber) throws Exception;
    public  void getAccount(String accountNumber);
    public  void doTransaction(BankAccountEntity account, double amount, String description) throws Exception;
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber);
    public List<TransactionEntity> getTransactionsOccurredOntime(String accountNumber, long startTime, long endTime);
    public List<TransactionEntity> getTransactionsOccurredLastest(String accountNumber, int m);
}
