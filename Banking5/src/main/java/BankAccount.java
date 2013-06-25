import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO mockBankAccountDAO;
    private static TransactionDAO mockTransactionDAO;

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        mockBankAccountDAO.save(account);
        return account;
    }

    public static void setDAO(BankAccountDAO mockBankAccountDAO) {
        BankAccount.mockBankAccountDAO = mockBankAccountDAO;
    }

    public static void getAccount(String accountNumber) {
        mockBankAccountDAO.find(accountNumber);
    }

    public static void doTransaction(BankAccountDTO account, double amount, String description) {
        account.setBalance(account.getBalance()+amount);
        mockBankAccountDAO.save(account);
    }

    public static List<TransactionDTO> getTransactionsOccurred(String accountNumber) {
        return Transaction.getTransactionsOccurred(accountNumber);
    }

    public static void setDAO(TransactionDAO mockTransactionDAO)
    {
        BankAccount.mockTransactionDAO = mockTransactionDAO;
    }

    public static List<TransactionDTO> getTransactionsOccurredOntime(String accountNumber, long startTime, long endTime) {
        return Transaction.getTransactionsOccurredOnTime(accountNumber, startTime, endTime);
    }

    public static List<TransactionDTO> getTransactionsOccurredLastest(String accountNumber, int m) {
        return Transaction.getTransactionsOccurredLastest(accountNumber,m);
    }
}
