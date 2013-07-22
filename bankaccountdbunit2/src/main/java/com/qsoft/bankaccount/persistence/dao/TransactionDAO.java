package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/07/2013
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public interface TransactionDAO {
    List<TransactionEntity> getTransaction(String accountNumber);
}
