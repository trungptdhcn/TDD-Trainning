import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

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

    }
    public void testOpenAccountWithBalanceIsZero()
    {
        BankAccount.openAccount("0123456789");
        ArgumentCaptor<BankAccountDTO> account = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO).save(account.capture());
        assertEquals(account.getValue().getNumberAccount(),"0123456789");
        assertEquals(account.getValue().getBalance(),0.0,0.01);

    }
}
