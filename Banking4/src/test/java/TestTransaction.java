import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/06/2013
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction extends TestCase {
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    @Before
    public void setUp()
    {
        reset(mockTransactionDAO);
        Transaction.setTransactionDAO(mockTransactionDAO);
    }


    public void testCreateTransactionWithTimeStamp()
    {
        //Prepare
        TransactionDTO transaction = Transaction.createTransaction("0123456789",100.0,"deposit");
        ArgumentCaptor<TransactionDTO> saveAgument = ArgumentCaptor.forClass(TransactionDTO.class);
        verify(mockTransactionDAO).save(saveAgument.capture());
        assertEquals(saveAgument.getValue().getAccountNumber(),"0123456789");
        assertEquals(saveAgument.getValue().getAmount(),100.0,0.01);
        assertEquals(saveAgument.getValue().getTimeStamp(),1000L);
        assertEquals(saveAgument.getValue().getDescription(),"deposit");

    }
}
