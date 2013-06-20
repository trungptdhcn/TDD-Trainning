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
    public static void setDAO(TransactionDAO mockTransactionDAO) {
        //To change body of created methods use File | Settings | File Templates.
        Transaction.mockTransactionDAO= mockTransactionDAO;
    }
    public static void createTransaction(String accountNumber,long timeStamp,double amount,String description)
    {
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
}
