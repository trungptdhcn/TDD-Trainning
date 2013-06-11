import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 11/06/2013
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    TransactionDAO mTransactionDAO;
    public  void setDAO(TransactionDAO mockTransactionDAO) {
        this.mTransactionDAO = mockTransactionDAO;

    }
    public TransactionDTO createTransaction(long timeStamp,String accountNumber,double amount,String description)
    {

        TransactionDTO mTransactionDTO =  new TransactionDTO(timeStamp,accountNumber,amount,description);
        mTransactionDAO.save(mTransactionDTO);
        return mTransactionDTO;

    }
}
