import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 11/06/2013
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO mTransactionDAO;

    public static void setTransactionDAO(TransactionDAO mTransactionDAO) {
        Transaction.mTransactionDAO = mTransactionDAO;
    }

    public static void createTransaction(String accountNumber, double amount, String description,long timeStamp) {
        TransactionDTO account = new TransactionDTO(accountNumber,amount,description,timeStamp);
        mTransactionDAO.save(account);

    }
}
