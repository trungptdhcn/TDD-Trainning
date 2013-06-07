import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void testgetAccountFunction()
    {
        mBankAccountDTO = mBankAcount.getAccount("0123456789");
        BankAccountDTO expectBankAcount = null;
        when(mockAcountDAO.find("0123456789")).thenReturn(expectBankAcount);
        assertEquals(mBankAccountDTO,expectBankAcount);
        verify(mockAcountDAO).find("0123456789");
    }
}
