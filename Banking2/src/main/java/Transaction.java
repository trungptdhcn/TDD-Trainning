/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO mTransactionDAO;
    public static void setDAO(TransactionDAO mockTransactionDAO) {
        //To change body of created methods use File | Settings | File Templates.
        Transaction.mTransactionDAO = mockTransactionDAO;
    }

    public static void doDeposit(String accountNumber, long timeStamp, double amount, String description) {
        TransactionDTO mTransactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        mTransactionDAO.save(mTransactionDTO);
    }

    public static void doWithDraw(String accountNumber, long timeStamp, double amount, String description) {
        TransactionDTO mTransactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        mTransactionDAO.save(mTransactionDTO);


    }
}
