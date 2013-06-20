import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 18/06/2013
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount extends TestCase {
    private BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        reset(mockTransactionDAO);
        BankAccount.setDAO(mockBankAccountDAO);
        Transaction.setDAO(mockTransactionDAO);

    }
    public void testOpenAccountWithBalanceIsZero()
    {
        BankAccount.openAccount("0123456789");
        ArgumentCaptor<BankAccountDTO> account = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO).save(account.capture());
        assertEquals(account.getValue().getNumberAccount(),"0123456789");
        assertEquals(account.getValue().getBalance(),0.0,0.01);

    }
    public void testGetAccountFromAccountNumber()
    {
        BankAccount.openAccount("0123456789");
        BankAccountDTO account = BankAccount.getAccount("0123456789");
        verify(mockBankAccountDAO).find("0123456789");
    }
    public void testDoTransaction()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.doTransaction(account,100.0,"deposit");


        ArgumentCaptor<BankAccountDTO> agument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(agument.capture());
        List<BankAccountDTO> saveRecord = agument.getAllValues();
        assertEquals(saveRecord.get(1).getNumberAccount(),"0123456789");
        assertEquals(saveRecord.get(1).getBalance(),100.0);

        BankAccount.doTransaction(account,-10.0,"withdraw");
        verify(mockBankAccountDAO,times(3)).save(agument.capture());
        List<BankAccountDTO> saveRecord2 = agument.getAllValues();

        assertEquals(saveRecord.get(2).getNumberAccount(),"0123456789");
        assertEquals(saveRecord.get(2).getBalance(),90.0);
    }
    public void testGetTransactionsOccurred()
    {
         BankAccountDTO account = BankAccount.openAccount("0123456789");
         BankAccount.getTransactionOccurred(account.getNumberAccount());
         List<TransactionDTO> transaction = new ArrayList<TransactionDTO>();
         when( BankAccount.getTransactionOccurred(account.getNumberAccount())).thenReturn(transaction);
         verify(mockTransactionDAO).get("0123456789");

    }
}
