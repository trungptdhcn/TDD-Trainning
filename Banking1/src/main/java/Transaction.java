import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public static TransactionDTO createTransaction(String accountNumber, double amount, String description,long timeStamp) {
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,amount,description,timeStamp);
        mTransactionDAO.save(transactionDTO);
        return transactionDTO;
    }

    public static List<TransactionDTO> getTransactions(String accountNumber,long startTime,long endTime) {
        List<TransactionDTO> mListTransactions = new ArrayList<TransactionDTO>();
        mListTransactions = mTransactionDAO.get(accountNumber,startTime,endTime);
        return mListTransactions;
    }
}
