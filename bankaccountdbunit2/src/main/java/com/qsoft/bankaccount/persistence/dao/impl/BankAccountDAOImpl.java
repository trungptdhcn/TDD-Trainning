package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/07/2013
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class BankAccountDAOImpl implements BankAccountDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BankAccountEntity find(String accountNumber) {
        Query query = entityManager.createQuery("select o from BankAccountEntity o where o.accountNumber = :qAccountNumber", BankAccountEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        List<BankAccountEntity> list = query.getResultList();
        if (list.size() == 0)
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }

    @Override
    public void save(BankAccountEntity bankAccountEntity) {
        if (bankAccountEntity.getId()!= null)
        {
            entityManager.merge(bankAccountEntity);
        } else
        {
            entityManager.persist(bankAccountEntity);
        }

    }
}
