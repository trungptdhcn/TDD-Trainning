/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 24/06/2013
 * Time: 13:33
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
        BankAccount.mockBankAccountDAO = mockBankAccountDAO;
    }

    public static void getAccount(String accountNumber) {
        mockBankAccountDAO.find(accountNumber);
    }
}
