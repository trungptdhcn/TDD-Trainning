package com.qsoft.bankaccount.persistence.dao.impl;


import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/07/2013
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class TransactionDAOImpl implements TransactionDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TransactionEntity> getTransaction(String accountNumber)
    {
        Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber", TransactionEntity.class");

    }
}
