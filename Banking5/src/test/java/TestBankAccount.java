import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount extends TestCase {
        public void testOpenAccountwithBalanceisZero()
        {
            //preparing
            BankAccountDTO account = BankAccount.openAccount("0123456789");
            assertEquals(account.getBalance(),0.0,0.01);

        }
}
