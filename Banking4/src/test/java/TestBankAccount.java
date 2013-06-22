import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/06/2013
 * Time: 13:53
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
    }
    public void testOpenAccountWithBalanceIsZero()
    {
        //Prepare
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        assertEquals(account.getBalance(),0.0,0.01);
        verify(mockBankAccountDAO).save(account);
    }
    public void testGetAccount()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.getAccount("0123456789");
        when(mockBankAccountDAO.find("0123456789")).thenReturn(account);
        verify(mockBankAccountDAO).find("0123456789");
    }
    public void testDoTransactionBalanceIncrementAmount()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.doTransaction(account,100.0,"deposit");
        ArgumentCaptor<BankAccountDTO> saveagument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(saveagument.capture());
        List<BankAccountDTO> saveRecord = saveagument.getAllValues();
        assertEquals(saveRecord.get(1).getAccountNumber(),"0123456789");
        assertEquals(saveRecord.get(1).getBalance(),100.0,0.01);

        BankAccount.doTransaction(account,-10.0,"withdraw");
        //ArgumentCaptor<BankAccountDTO> saveagument2 = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(3)).save(saveagument.capture());
        List<BankAccountDTO>saveRecord2 = saveagument.getAllValues();
        assertEquals(saveRecord.get(2).getAccountNumber(),"0123456789");
        assertEquals(saveRecord.get(2).getBalance(),90,0.01);
    }
    public void testGetTransactionsOccurred()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        List<TransactionDTO> mList =  BankAccount.getTransactionsOccurred(account.getAccountNumber());
        verify(mockTransactionDAO).get("0123456789");

    }
    public void testGetTransactionsOccurredONTIME()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        List<TransactionDTO> mlist = BankAccount.getTransactionsOccurredOnTime(account.getAccountNumber(),1000L,1200L);
        verify(mockTransactionDAO).getOnTime("0123456789",1000L,1200L);
    }
}
