import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/06/2013
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount extends TestCase {
    private BankAccount mBankAcount;
    private BankAccountDAO mockAcountDAO = mock(BankAccountDAO.class);
    private BankAccountDTO mBankAccountDTO = new BankAccountDTO("");
    @Before
    public void setUp()
    {
        mBankAcount = new BankAccount(mockAcountDAO);
    }
    public void testFunctionSaveSureCalled()
    {
        mBankAcount.openAccount("0123456789");
        ArgumentCaptor<BankAccountDTO> saveAccountRecords = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockAcountDAO).save(saveAccountRecords.capture());
        assertEquals(saveAccountRecords.getValue().getBalance(),0.0,0.1);

    }
}
