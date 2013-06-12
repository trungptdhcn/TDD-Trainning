import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/06/2013
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount extends TestCase {
    private BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    private Calendar mockCalender = mock(Calendar.class);
    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        //reset(mockCalender);
        //reset(mockTransactionDAO);
        BankAccount.setDAO(mockBankAccountDAO);
        TransactionDTO.setCalender(mockCalender);
        Transaction.setTransactionDAO(mockTransactionDAO);
        //BankAccount.setDAO();
    }
    public void testNewAccountHasZeroBalanceAndIsPersitent()
    {
        BankAccount.openAccount("0123456789");
        ArgumentCaptor<BankAccountDTO> savedAccountRecords = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO).save(savedAccountRecords.capture());
        assertEquals(savedAccountRecords.getValue().getBalance(),0.0,0.01);
        assertEquals(savedAccountRecords.getValue().getAccountNumber(),"0123456789");

    }
    public void testCanGetAccountDTOfromDAO()
    {
//        BankAccount.openAccount("0123456780");
//        BankAccountDTO expectAccountDTO = null;
//        when(mockBankAccountDAO.find("0123456789")).thenReturn(expectAccountDTO);
//        BankAccountDTO actualBankAccountDTO = BankAccount.getAccount("0123456789");
//        assertEquals(expectAccountDTO,actualBankAccountDTO);
        BankAccount.getAccount("0123456789");
        verify(mockBankAccountDAO).find("0123456789");


    }
    public void testTransactionChangesBalanceAndIsPersistent()
    {
        when(mockCalender.getTimeInMillis()).thenReturn(1000L);
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.doTransaction(account,100.0,"deposit",mockCalender.getTimeInMillis());

        BankAccount.doTransaction(account,-10.0,"withdraw",mockCalender.getTimeInMillis());

        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);

        verify(mockBankAccountDAO,times(3)).save(argument.capture());
        List<BankAccountDTO> saveRecordsAccount = argument.getAllValues();

        assertEquals(saveRecordsAccount.get(2).getBalance(),90.0,0.01);
        assertEquals(saveRecordsAccount.get(2).getAccountNumber(),"0123456789");
    }
    public void testGetTransactionsOccurredOnTime()
    {
        BankAccount.getTransactionsOccurred("0123456789",1000L,1200L);
        ArgumentCaptor<String> agumentString = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Long> startTime1 = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> startTime2 = ArgumentCaptor.forClass(Long.class);
        verify(mockTransactionDAO).get(agumentString.capture(),startTime1.capture(),startTime2.capture());
        assertEquals(startTime1.getValue().longValue(),1000L);
        assertEquals(startTime2.getValue().longValue(),1200L);
        assertEquals(agumentString.getValue().toString(),"0123456789");
    }
    public void testGetNTransactionNews()
    {
        BankAccount.getTransactionNews("0123456789",9);
        ArgumentCaptor<String> argumentAccountNumber = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> argumentTransactions = ArgumentCaptor.forClass(Integer.class);
        verify(mockTransactionDAO).getNewTransactions(argumentAccountNumber.capture(),argumentTransactions.capture());

        assertEquals(argumentAccountNumber.getValue().toString(),"0123456789");
        assertEquals(argumentTransactions.getValue().intValue(),9);
    }

}
