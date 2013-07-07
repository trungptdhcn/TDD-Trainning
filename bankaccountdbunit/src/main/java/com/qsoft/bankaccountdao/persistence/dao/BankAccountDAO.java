package com.qsoft.bankaccountdao.persistence.dao;

import com.qsoft.bankaccountdao.persistence.model.BankAccountEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 04/07/2013
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public interface BankAccountDAO {
    public void save(BankAccountEntity account);

    public BankAccountEntity find(String accountNumber);
}
