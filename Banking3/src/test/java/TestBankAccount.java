import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

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
    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        BankAccount.setDAO(mockBankAccountDAO);

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
    public void testDepositAccountBalanceIncrementAmount()
    {
        BankAccountDTO mAccountDTO = BankAccount.openAccount("0123456789");

        BankAccount.deposit(mAccountDTO,100.0,"deposit");

        ArgumentCaptor<BankAccountDTO> accountRecord = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(accountRecord.capture());
        List<BankAccountDTO> saveRecord = accountRecord.getAllValues();
        assertEquals(saveRecord.get(1).getNumberAccount(),"0123456789");
        assertEquals(saveRecord.get(1).getBalance(),100.0,0.01);


    }
}
