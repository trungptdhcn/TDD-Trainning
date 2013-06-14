import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO;
    //private static TransactionDAO transactionDAO;

    public static void setDAO(BankAccountDAO bankAccountDAO,TransactionDAO mTransactionDAO)
    {
        BankAccount.bankAccountDAO = bankAccountDAO;
        Transaction.setDAO(mTransactionDAO);
    }

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        bankAccountDAO.save(account);
        return account;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        BankAccountDTO resultBankAccountDTO = bankAccountDAO.find(accountNumber);
        return resultBankAccountDTO;  //To change body of created methods use File | Settings | File Templates.
    }

    public static void doTransaction(BankAccountDTO accountDTO, double amount, String description) {
        accountDTO.setBalance(accountDTO.getBalance()+amount);
        bankAccountDAO.save(accountDTO);

    }

    public static List<TransactionDTO> getTransactionsOccurred(String accountNumber) {
        return Transaction.getTransactionsOccurred(accountNumber);
        //return null;
    }

    public static  List<TransactionDTO> getTransactionsOccurredOnTime(String accountNumber, long startTime, long endTime) {
        return Transaction.getTransactionsOccurredOnTime(accountNumber,startTime,endTime);
    }
}
