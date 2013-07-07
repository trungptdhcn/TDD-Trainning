package com.qsoft.bankaccountdao.persistence.dao;

import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public interface TransactionDAO {
    public void save(TransactionEntity transaction);
    public List<TransactionEntity> find(String accountNumber);
    public List<TransactionEntity> findOneTime(String accountNumber, long startTime, long endTime);
    public List<TransactionEntity> findLastest(String accountNumber, int m);
}
