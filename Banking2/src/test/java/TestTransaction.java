import junit.framework.TestCase;

import static org.mockito.Mockito.reset;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction extends TestCase {
    private TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);

    public void setUp()
    {
        reset(mockTransactionDAO);
        Transaction.setDAO(mockTransactionDAO);
    }
    public void test
}
