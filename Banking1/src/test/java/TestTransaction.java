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
    TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    @Before
    public void setUp()
    {

        reset(mockTransactionDAO);
        Transaction.setDAO(mockTransactionDAO);

    }
    public void testDepositTransaction()
    {
        Calendar c = mock(Calendar.class);
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setC(c);
        when(c.getTimeInMillis()).thenReturn(1000);
        Transaction.createTransaction("0123456789",timeCurent,100,"deposit");
        ArgumentCaptor<TransactionDTO>transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO,times(1)).save(transactionRecords.capture());
    }
}
