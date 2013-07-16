package com.qsoft.bankaccountdao.business.Impl;

import com.qsoft.bankaccountdao.business.BankAccountService;
import com.qsoft.bankaccountdao.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
import com.qsoft.bankaccountdao.persistence.model.BankAccountEntity;
import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountDAO mockBankAccountDAO;
    private TransactionDAO mockTransactionDAO;

    @Override
    public void setDAO(BankAccountDAO mockBankAccountDAO, TransactionDAO mockTransactionDAO) {
        this.mockBankAccountDAO = mockBankAccountDAO;
        this.mockTransactionDAO = mockTransactionDAO;
    }

    @Override
    public BankAccountEntity openAccount(String accountNumber) throws Exception{
        BankAccountEntity account = new BankAccountEntity(accountNumber);
        mockBankAccountDAO.save(account);
        return account;
    }

    @Override
    public void getAccount(String accountNumber) {
        mockBankAccountDAO.find(accountNumber);
    }

    @Override
    public void doTransaction(BankAccountEntity account, double amount, String description)throws Exception{
        account.setBalance(account.getBalance()+amount);
        mockBankAccountDAO.save(account);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurredOntime(String accountNumber, long startTime, long endTime) {
        List<TransactionEntity> list = new ArrayList<TransactionEntity>();
        TransactionEntity transaction = new TransactionEntity();
        mockTransactionDAO.find(accountNumber);
        list.add(transaction);
        return list;    }

    @Override
    public List<TransactionEntity> getTransactionsOccurredLastest(String accountNumber, int m) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
