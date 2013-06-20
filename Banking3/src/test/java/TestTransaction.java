import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 19/06/2013
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction extends TestCase {
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    private Calendar mockCalendar = mock(Calendar.class);
    @Before
    public void setUp()
    {
        reset(mockTransactionDAO);
        reset(mockCalendar);
        Transaction.setDAO(mockTransactionDAO);

    }
    public void testSaveTransactionAfterDeposit()
    {
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L,1200L);

        Transaction.createTransaction("0123456789",mockCalendar.getTimeInMillis(),100.0,"deposit");
        Transaction.createTransaction("0123456789",mockCalendar.getTimeInMillis(),-10.0,"withdraw");
        ArgumentCaptor<TransactionDTO> agument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO,times(2)).save(agument.capture());

        List<TransactionDTO> TransactionRecord = agument.getAllValues();
        assertEquals(TransactionRecord.get(0).getAcountNumber(),"0123456789");
        assertEquals(TransactionRecord.get(0).getTimeStamp(),1000L);
        assertEquals(TransactionRecord.get(0).getAmount(),100.0);
        assertEquals(TransactionRecord.get(0).getDescription(),"deposit");

        assertEquals(TransactionRecord.get(1).getAcountNumber(),"0123456789");
        assertEquals(TransactionRecord.get(1).getTimeStamp(),1200L);
        assertEquals(TransactionRecord.get(1).getAmount(),-10.0);
        assertEquals(TransactionRecord.get(1).getDescription(),"withdraw");


    }
}
