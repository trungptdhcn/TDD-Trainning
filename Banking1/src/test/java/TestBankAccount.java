import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

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
    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        BankAccount.setDAO(mockBankAccountDAO);
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

        BankAccountDTO account = BankAccount.openAccount("0123456780");
        System.out.println(account.getBalance());
        BankAccount.doTransaction(account,100.0);
        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);

        BankAccount.doTransaction(account,-10.0);
        verify(mockBankAccountDAO,times(3)).save(argument.capture());
        List<BankAccountDTO> saveRecordsAccount = argument.getAllValues();
        assertEquals(saveRecordsAccount.get(2).getBalance(),90.0,0.01);
    }

}
