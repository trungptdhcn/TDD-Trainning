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
        BankAccountDTO expectBankAcount = mBankAcount.openAccount("0123456789");
        when(mockAcountDAO.find("0123456789")).thenReturn(expectBankAcount);
        mBankAccountDTO = mBankAcount.getAccount(expectBankAcount.getAccountNumber());
        assertEquals(expectBankAcount,mBankAccountDTO);
        verify(mockAcountDAO).find("0123456789");
    }
    @After
    public void tearDown() throws Exception {
        if(mockAcountDAO != null) {
            reset(mockAcountDAO);
        }
    }
    public void testBankAccountDeposit()
    {
       BankAccountDTO bankAccountDTO = mBankAcount.openAccount("0123456789");
       mBankAcount.depositAccount(bankAccountDTO,50.0,"gui vao 50");
        ArgumentCaptor<BankAccountDTO> agument = ArgumentCaptor.forClass(BankAccountDTO.class);

       verify(mockAcountDAO,times(2)).save(agument.capture());
       List<BankAccountDTO> list = agument.getAllValues();
       assertEquals(list.get(1).getBalance(),50.0,0.01);

    }
}
