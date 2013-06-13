import junit.framework.TestCase;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

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
    public void testCreateTransaction()
    {
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);
        Transaction.doTransaction("0123456789", mockCalendar.getTimeInMillis(), 100.0, "deposit");
        Transaction.doTransaction("0123456789",mockCalendar.getTimeInMillis(),-50.0,"withdraw");
        ArgumentCaptor<TransactionDTO> transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO,times(2)).save(transactionRecords.capture());
        List<TransactionDTO> mRecordTransaction = transactionRecords.getAllValues();

        assertEquals(mRecordTransaction.get(0).getAccountNumber(),"0123456789");
        assertEquals(mRecordTransaction.get(0).getAmount(),100.0,0.01);
        assertEquals(mRecordTransaction.get(0).getDescription(),"deposit");
        assertEquals(mRecordTransaction.get(0).getTimeStamp(),1000L);

        assertEquals(mRecordTransaction.get(1).getAccountNumber(),"0123456789");
        assertEquals(mRecordTransaction.get(1).getAmount(),-50.0,0.01);
        assertEquals(mRecordTransaction.get(1).getDescription(),"withdraw");
        assertEquals(mRecordTransaction.get(1).getTimeStamp(),1000L);

    }

}
