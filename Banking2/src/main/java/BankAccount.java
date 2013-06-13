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

    public static void openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        bankAccountDAO.save(account);
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
