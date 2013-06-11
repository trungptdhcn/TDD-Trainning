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
    Transaction mTransaction = new Transaction();
    @Before
    public void setUp()
    {

        reset(mockTransactionDAO);

        mTransaction.setDAO(mockTransactionDAO);

    }
    public void testDepositTransaction()
    {
         TransactionDTO transactionDTO = new TransactionDTO();
        Calendar c = mock(Calendar.class);
        transactionDTO.setC(c);
        when(c.getTimeInMillis()).thenReturn(1000L);

        transactionDTO = mTransaction.createTransaction(c.getTimeInMillis(),"0123456789",50,"deposit");


        //when(mockTransactionDAO.save(transactionDTO))
        ArgumentCaptor<TransactionDTO>transactionRecords = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO).save(transactionRecords.capture());
        assertEquals(transactionRecords.getValue().getAccountNumber(),"0123456789");
        assertEquals(transactionRecords.getValue().getDescription(),"deposit");
        assertEquals(transactionRecords.getValue().getAmount(),50.0);
        assertEquals(transactionRecords.getValue().getTimeStamp(),1000L);
    }
}
