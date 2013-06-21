/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/06/2013
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO mockTransactionDAO;
    public static void setTransactionDAO(TransactionDAO mockTransactionDAO) {
        //To change body of created methods use File | Settings | File Templates.
        Transaction.mockTransactionDAO = mockTransactionDAO;
    }

    public static TransactionDTO createTransaction(String accountNumber, double amount, String description) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
