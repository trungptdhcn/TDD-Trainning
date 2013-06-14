import javafx.beans.binding.When;
import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount extends TestCase {
    private BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        BankAccount.setDAO(mockBankAccountDAO,mockTransactionDAO);

    }
    public void testOpenAccount()
    {
        BankAccount.openAccount("0123456789");

        ArgumentCaptor<BankAccountDTO> saveAccountRecords = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO).save(saveAccountRecords.capture());
        assertEquals(saveAccountRecords.getValue().getBalance(),0.0,0.01);
        assertEquals(saveAccountRecords.getValue().getAccountNumber(),"0123456789");
    }

    public void testGetAccount()
    {
        BankAccountDTO mAccountDTO = BankAccount.getAccount("0123456789");
        //ArgumentCaptor<S>
        verify(mockBankAccountDAO).find("0123456789");
    }

    public void testDepositAccount()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");

        BankAccount.doTransaction(account,100.0,"deposit");

        ArgumentCaptor<BankAccountDTO> agument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(agument.capture());
        List<BankAccountDTO> saveRecord = agument.getAllValues();
        assertEquals(saveRecord.get(1).getBalance(),100.0,0.01);
        assertEquals(saveRecord.get(1).getAccountNumber(),"0123456789");

        BankAccount.doTransaction(account,-10.0,"withdraw");
        verify(mockBankAccountDAO,times(3)).save(agument.capture());
        List<BankAccountDTO> saveRecord2 = agument.getAllValues();

        assertEquals(saveRecord2.get(2).getAccountNumber(),"0123456789");
        assertEquals(saveRecord2.get(2).getBalance(),90.0,0.01);
    }

    public void testGetTransactionsOccurred()
    {
        List<TransactionDTO> mTransactionDTOs = new ArrayList<TransactionDTO>();
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.getTransactionsOccurred(account.getAccountNumber());
        when(BankAccount.getTransactionsOccurred(account.getAccountNumber())).thenReturn(mTransactionDTOs);
        verify(mockTransactionDAO).get("0123456789");
    }
    public void testGetTransactionsOccurredOnTime()
    {
        //When
        List<TransactionDTO> mTransactionDTOs = new ArrayList<TransactionDTO>();
        BankAccountDTO account = BankAccount.openAccount("0123456789");

        BankAccount.getTransactionsOccurredOnTime(account.getAccountNumber(), 1000L, 1200L);
        when(BankAccount.getTransactionsOccurredOnTime(account.getAccountNumber(),1000L,1200L)).thenReturn(mTransactionDTOs);
        verify(mockTransactionDAO).getOnTime("0123456789",1000L,1200L);
    }
    public void testGetNTransactionsNews()
    {
        List<TransactionDTO> mTransactionDTONews = new ArrayList<TransactionDTO>();
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.getNTransactionNews(account.getAccountNumber(),9);
        ArgumentCaptor<Integer> NumberTransactions = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> accountNumbers = ArgumentCaptor.forClass(String.class);

        when(BankAccount.getNTransactionNews(account.getAccountNumber(),9)).thenReturn(mTransactionDTONews);
        verify(mockTransactionDAO).getNTransactionNews(accountNumbers.capture(),NumberTransactions.capture());
        assertEquals(NumberTransactions.getValue().intValue(),9);

    }


}
