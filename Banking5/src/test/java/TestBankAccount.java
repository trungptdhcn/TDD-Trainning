import junit.framework.TestCase;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:31
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
}
