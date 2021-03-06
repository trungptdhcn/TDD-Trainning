import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 20/06/2013
 * Time: 08:51
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO mockTransactionDAO;
    private static Calendar mockcalendar;

    public static void setDAO(TransactionDAO mockTransactionDAO,Calendar mockcalendar) {
        //To change body of created methods use File | Settings | File Templates.
        Transaction.mockTransactionDAO= mockTransactionDAO;
        Transaction.mockcalendar = mockcalendar;
    }
    public static void createTransaction(String accountNumber,double amount,String description)
    {
        long timeStamp = Transaction.mockcalendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        mockTransactionDAO.save(transactionDTO);
    }
    {

    }

    public static List<TransactionDTO> getTransactionOccurred(String numberAccount) {
        return mockTransactionDAO.get(numberAccount);
    }

    public static List<TransactionDTO> getTransactionsOccurredOneTime(String numberAccount, long startime, long endTime) {
        return mockTransactionDAO.getOnTime(numberAccount,startime,endTime);
    }

    public static List<TransactionDTO> getTransactionLastest(String numberAccount, int n) {
        return mockTransactionDAO.getLastest(numberAccount,n);
    }
}
