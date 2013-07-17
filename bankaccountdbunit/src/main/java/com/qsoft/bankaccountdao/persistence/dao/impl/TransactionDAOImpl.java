package com.qsoft.bankaccountdao.persistence.dao.impl;

import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(TransactionEntity transaction) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> find(String accountNumber) {
        Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber", TransactionEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        List<TransactionEntity> list = query.getResultList();
        if (list.size() == 0)
        {
            return null;
        }
        else
            return list;
    }

    @Override
    public List<TransactionEntity> findOneTime(String accountNumber, long startTime, long endTime) {
        Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber and o.timeStamp>:qstartTime and o.timeStamp<:qendTime", TransactionEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        query.setParameter("qstartTime", startTime);
        query.setParameter("qendTime", endTime);
        List<TransactionEntity> list = query.getResultList();
        if (list.size() == 0)
        {
            return null;
        }
        else
            return list;
    }

    @Override
    public List<TransactionEntity> findLastest(String accountNumber, int m) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public TransactionEntity find(TransactionEntity transactionEntity)
    {
        return entityManager.find(TransactionEntity.class,transactionEntity.getId());
    }
}
