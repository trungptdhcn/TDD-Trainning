import junit.framework.TestCase;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction extends TestCase {
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    private Calendar mockCalendar = mock(Calendar.class);

    public void setUp()
    {
        reset(mockTransactionDAO);
        Transaction.setDAO(mockTransactionDAO);
    }
    public void testCreateDepositTransaction()
    {
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);
        Transaction.doDeposit("0123456789",mockCalendar.getTimeInMillis(),100.0,"deposit");
        ArgumentCaptor<TransactionDTO> transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO,times(1)).save(transactionRecords.capture());

        assertEquals(transactionRecords.getValue().getAccountNumber(),"0123456789");
        assertEquals(transactionRecords.getValue().getAmount(),100.0,0.01);
        assertEquals(transactionRecords.getValue().getDescription(),"deposit");
        assertEquals(transactionRecords.getValue().getTimeStamp(),1000L);

    }

}
