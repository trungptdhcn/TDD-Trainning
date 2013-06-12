import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 11/06/2013
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction extends TestCase {
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    private Calendar mockCalender = mock(Calendar.class);
    @Before
    public void setUp()
    {
        reset(mockTransactionDAO);
        Transaction.setTransactionDAO(mockTransactionDAO);
        TransactionDTO.setCalender(mockCalender);
    }
    public void testNewTransactionIsNotYetExecutedButPersistent()
    {
        when(mockCalender.getTimeInMillis()).thenReturn(1000L);
        Transaction.createTransaction("0123456789",100.0,"deposit",mockCalender.getTimeInMillis());
        ArgumentCaptor<TransactionDTO> TransactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO).save(TransactionRecords.capture());
        assertEquals(TransactionRecords.getValue().getAmount(),100.0,0.01);
        assertEquals(TransactionRecords.getValue().getAccountNumber(),"0123456789");
        assertEquals(TransactionRecords.getValue().getDescription(),"deposit");
        assertEquals(TransactionRecords.getValue().getTimeStamp(),1000L);
    }

}
