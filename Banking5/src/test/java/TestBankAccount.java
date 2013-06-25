import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount extends TestCase {
    private BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);

    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        BankAccount.setDAO(mockBankAccountDAO);
        BankAccount.setDAO(mockTransactionDAO);
    }
    public void testOpenAccountwithBalanceisZero() {
        //preparing
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        assertEquals(account.getBalance(), 0.0, 0.01);
        verify(mockBankAccountDAO).save(account);

    }
    public void testGetAccount()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.getAccount(account.getAccountNumber());
        verify(mockBankAccountDAO).find(account.getAccountNumber());
    }
    public void testDoTransaction()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.doTransaction(account,100.0,"deposit");
        //BankAccount.doTransaction(account,-10,"withdraw");
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(argument.capture());

        List<BankAccountDTO> save = argument.getAllValues();
        assertEquals(save.get(1).getAccountNumber(),"0123456789");
        assertEquals(save.get(1).getBalance(),100.0,0.01);

    }
    public void testGetTransactionsOccurred()
    {
        List<TransactionDTO> listTransaction = new ArrayList<TransactionDTO>();
        when(BankAccount.getTransactionsOccurred("0123456789")).thenReturn(listTransaction);
        verify(mockTransactionDAO).find("0123456789");

    }
}
