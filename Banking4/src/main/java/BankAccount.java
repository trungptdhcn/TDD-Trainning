import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/06/2013
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO mockBankAccountDAO;
    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        mockBankAccountDAO.save(account);
        return  account;
    }

    public static void setDAO(BankAccountDAO mockBankAccountDAO) {
        BankAccount.mockBankAccountDAO = mockBankAccountDAO;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return mockBankAccountDAO.find(accountNumber);
    }

    public static void doTransaction(BankAccountDTO account, double amount, String description) {
        account.setBalance(account.getBalance()+amount);
        mockBankAccountDAO.save(account);
    }

    public static List<TransactionDTO> getTransactionsOccurred(String accountNumber) {
        return Transaction.getTransactionsOccurred(accountNumber);
    }

    public static List<TransactionDTO> getTransactionsOccurredOnTime(String accountNumber, long startTime, long endTime) {
        return Transaction.getTransactionsOccurredOnTime(accountNumber, startTime, endTime);
    }

    public static List<TransactionDTO> getLastestTransaction(String accountNumber, int number) {
        return Transaction.getLastestTransaction(accountNumber,number);
    }
}
