import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 19/06/2013
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO mockBankAccountDAO;
    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        mockBankAccountDAO.save(account);
        return account;
    }

    public static void setDAO(BankAccountDAO mockBankAccountDAO) {
        //To change body of created methods use File | Settings | File Templates.
        BankAccount.mockBankAccountDAO = mockBankAccountDAO;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return mockBankAccountDAO.find(accountNumber);
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void doTransaction(BankAccountDTO mAccountDTO, double amount, String description) {
        //To change body of created methods use File | Settings | File Templates.
        mAccountDTO.setBalance(mAccountDTO.getBalance()+amount);
        mockBankAccountDAO.save(mAccountDTO);
       // Transaction.createTransaction(mAccountDTO.getNumberAccount());
    }


    public static List<TransactionDTO> getTransactionOccurred(String numberAccount) {
        return Transaction.getTransactionOccurred(numberAccount);
    }

    public static List<TransactionDTO> getTransactionsOccurredOneTime(String numberAccount, long startime, long endTime) {
        return Transaction.getTransactionsOccurredOneTime(numberAccount,startime,endTime);
    }

    public static List<TransactionDTO> getTransactionLastest(String numberAccount, int n) {
        return Transaction.getTransactionLastest(numberAccount,n);
    }
}
