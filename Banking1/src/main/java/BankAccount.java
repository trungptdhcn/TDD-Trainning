import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/06/2013
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO mBankAccountDAO;
    //private static TransactionDAO mTransactionDAO;

    public static void setDAO(BankAccountDAO mBankAccountDAO) {
        BankAccount.mBankAccountDAO = mBankAccountDAO;
        //BankAccount.mTransactionDAO = mTransactionDAO;

    }

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        mBankAccountDAO.save(bankAccountDTO);
        return bankAccountDTO;


    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return mBankAccountDAO.find(accountNumber);

    }

    public static TransactionDTO doTransaction(BankAccountDTO bankAccountDTO,double amount,String description,long timeStamp) {

        bankAccountDTO.setBalance(bankAccountDTO.getBalance()+amount);
        mBankAccountDAO.save(bankAccountDTO);
        //TransactionDTO mTransactionDTO = new TransactionDTO(bankAccountDTO.getAccountNumber(),amount,description,timeStamp);
        TransactionDTO mTransactionDTO = Transaction.createTransaction(bankAccountDTO.getAccountNumber(),amount,description,timeStamp);
        return mTransactionDTO;

    }
    public static List<TransactionDTO> getTransactionsOccurred(String accountNumber)
    {
        List<TransactionDTO> mListTransactions = new ArrayList<TransactionDTO>();
        mListTransactions = Transaction.getTransactions(accountNumber);
        return mListTransactions;
    }
}
