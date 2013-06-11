import junit.framework.TestCase;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

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

        Transaction.createTransaction("0123456789",100,"deposit");
    }
}
