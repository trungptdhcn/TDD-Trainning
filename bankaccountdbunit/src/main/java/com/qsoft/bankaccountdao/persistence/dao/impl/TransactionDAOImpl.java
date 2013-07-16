package com.qsoft.bankaccountdao.persistence.dao.impl;

import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public void save(TransactionEntity transaction) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> find(String accountNumber) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> findOneTime(String accountNumber, long startTime, long endTime) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> findLastest(String accountNumber, int m) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
