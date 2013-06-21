import junit.framework.TestCase;
import org.junit.Before;

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
}
