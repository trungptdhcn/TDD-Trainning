import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

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
    @Before
    public void setUp()
    {
        reset(mockBankAccountDAO);
        BankAccount.setDAO(mockBankAccountDAO);

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

        BankAccount.deposit(account,100.0,"deposit");
        ArgumentCaptor<BankAccountDTO> agument = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(agument.capture());
        List<BankAccountDTO> saveRecord = agument.getAllValues();

        assertEquals(saveRecord.get(1).getBalance(),100.0,0.01);
        assertEquals(saveRecord.get(1).getAccountNumber(),"0123456789");
        //assertEquals(saveRecord.get(1).getDescription(),"deposit");
    }
    public void testWithDrawAccount()
    {
        BankAccountDTO account = BankAccount.openAccount("0123456789");
        BankAccount.deposit(account,100.0,"deposit");
        BankAccount.withdraw(account,50.0,"withdraw");

        ArgumentCaptor<BankAccountDTO> argument = ArgumentCaptor.forClass(BankAccountDTO.class);

        verify(mockBankAccountDAO,times(3)).save(argument.capture());
        List<BankAccountDTO> saveRecords = argument.getAllValues();
        assertEquals(saveRecords.get(2).getBalance(),90.0,0.01);
        assertEquals(saveRecords.get(2).getAccountNumber(),"0123456789");
        //assertEquals(saveRecords.get(2).getDescription(),"");

    }


}
