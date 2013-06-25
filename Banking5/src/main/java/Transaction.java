import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO mockTransactionDAO;
    private static Calendar mockCalendar;
    public static void setDAOTransaction(TransactionDAO mockTransactionDAO,Calendar mockCalendar)
    {
        Transaction.mockTransactionDAO = mockTransactionDAO;
        Transaction.mockCalendar = mockCalendar;
    }
    public static TransactionDTO createTransaction(String accountNumber, double amount, String description) {
        long timeStamp = Transaction.mockCalendar.getTimeInMillis();
        TransactionDTO transaction = new TransactionDTO(accountNumber,amount,timeStamp,description);
        mockTransactionDAO.save(transaction);
        return transaction;
    }

    public static List<TransactionDTO> getTransactionsOccurred(String accountNumber) {
        return mockTransactionDAO.find(accountNumber);
    }
}
