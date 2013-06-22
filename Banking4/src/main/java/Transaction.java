import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/06/2013
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO mockTransactionDAO;
    private static Calendar mockcalendar;
    public static void setTransactionDAO(TransactionDAO mockTransactionDAO,Calendar mockcalendar) {
        //To change body of created methods use File | Settings | File Templates.
        Transaction.mockTransactionDAO = mockTransactionDAO;
        Transaction.mockcalendar = mockcalendar;
    }

    public static TransactionDTO createTransaction(String accountNumber, double amount, String description) {
        long timeStamp = mockcalendar.getTimeInMillis();
        TransactionDTO transaction = new TransactionDTO(accountNumber,amount,timeStamp,description);
        mockTransactionDAO.save(transaction);
        return transaction;
    }

    public static List<TransactionDTO> getTransactionsOccurred(String accountNumber) {
        return mockTransactionDAO.get(accountNumber);
    }

    public static List<TransactionDTO> getTransactionsOccurredOnTime(String accountNumber, long startTime, long endTime) {
        return mockTransactionDAO.getOnTime(accountNumber,startTime,endTime);
    }
}
