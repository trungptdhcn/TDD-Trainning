package com.qsoft.bankaccountservice;

import com.qsoft.bankaccountdao.business.BankAccountService;
import com.qsoft.bankaccountdao.business.Impl.BankAccountServiceImpl;
import com.qsoft.bankaccountdao.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
import com.qsoft.bankaccountdao.persistence.model.BankAccountEntity;
import junit.framework.TestCase;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccountService extends TestCase{
    private BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    BankAccountService bankAccountService = new BankAccountServiceImpl();

    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        bankAccountService.setDAO(mockBankAccountDAO, mockTransactionDAO);
        //BankAccount.setDAO(mockTransactionDAO);
    }
    public void testOpenAccountwithBalanceisZero() throws Exception
    {
        //preparing
        BankAccountEntity account = bankAccountService.openAccount("0123456789");
        assertEquals(account.getBalance(), 0.0, 0.01);
        verify(mockBankAccountDAO).save(account);

    }
    public void testGetAccount() throws Exception
    {
        BankAccountEntity account = bankAccountService.openAccount("0123456789");
        bankAccountService.getAccount(account.getAccountNumber());
        verify(mockBankAccountDAO).find(account.getAccountNumber());
    }

}
