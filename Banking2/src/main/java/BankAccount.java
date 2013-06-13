/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO;

    public static void setDAO(BankAccountDAO bankAccountDAO)
    {
        BankAccount.bankAccountDAO = bankAccountDAO;
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

    public static void deposit(BankAccountDTO accountDTO, double amount, String description) {
        accountDTO.setBalance(accountDTO.getBalance()+amount);
        bankAccountDAO.save(accountDTO);

    }

    public static void withdraw(BankAccountDTO account, double amount, String description) {
        account.setBalance((account.getBalance()-amount));
        bankAccountDAO.save(account);
    }
}
