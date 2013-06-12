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
        BankAccount.openAccount("0123456789");
        BankAccountDTO expectAccountDTO = null;
        when(mockBankAccountDAO.find("0123456789")).thenReturn(expectAccountDTO);
        BankAccountDTO actualBankAccountDTO = BankAccount.getAccount("0123456789");
        assertEquals(expectAccountDTO,actualBankAccountDTO);
        verify(mockBankAccountDAO).find("0123456789");


    }
    public void testTransactionChangesBalanceAndIsPersistent()
    {
        when(mockCalender.getTimeInMillis()).thenReturn(1000L);

        BankAccountDTO account = BankAccount.openAccount("0123456789");
        System.out.println(account.getBalance());
        BankAccount.doTransaction(account,100.0,"deposit",mockCalender.getTimeInMillis());
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);

        BankAccount.doTransaction(account,-10.0,"deposit",mockCalender.getTimeInMillis());
        verify(mockBankAccountDAO,times(3)).save(argument.capture());
        List<BankAccountDTO> saveRecordsAccount = argument.getAllValues();
        assertEquals(saveRecordsAccount.get(2).getBalance(),90.0,0.01);
    }
    public void testGetTransactionsOccurred()
    {
        List<TransactionDTO> expectList = new ArrayList<TransactionDTO>();
        when(mockCalender.getTimeInMillis()).thenReturn(1000L);
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.doTransaction(account,100.0,"deposit",mockCalender.getTimeInMillis());
        BankAccount.doTransaction(account,-10.0,"withdraw",mockCalender.getTimeInMillis());
        expectList = BankAccount.getTransactionsOccurred("0123456789");


        List<TransactionDTO>actualsList = new ArrayList<TransactionDTO>();
        when(mockTransactionDAO.get("0123456789")).thenReturn(actualsList);
        assertEquals(expectList.size(),actualsList.size());



    }

}
