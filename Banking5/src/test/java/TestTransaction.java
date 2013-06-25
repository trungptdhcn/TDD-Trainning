import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction extends TestCase {
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    private Calendar mockCalendar = mock(Calendar.class);
    @Before
    public void setUp()
    {
        reset(mockCalendar);
        reset(mockTransactionDAO);
        Transaction.setDAOTransaction(mockTransactionDAO,mockCalendar);

    }
    public void testCreateTransaction()
    {
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);
        TransactionDTO transaction = Transaction.createTransaction("0123456789",100.0,"deposit");
        ArgumentCaptor<TransactionDTO> argument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO).save(argument.capture());
        assertEquals(argument.getValue().getAccountNumber(),"0123456789");
        assertEquals(argument.getValue().getAmount(),100.0);
        assertEquals(argument.getValue().getDescription(),"deposit");
        assertEquals(argument.getValue().getTimeStamp(),1000L);

        //List<TransactionDTO> saveRecord = new ArrayList<TransactionDTO>(argument);
    }
}
