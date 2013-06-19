/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 19/06/2013
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO mockBankAccountDAO;
    public static void openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        mockBankAccountDAO.save(account);
    }

    public static void setDAO(BankAccountDAO mockBankAccountDAO) {
        //To change body of created methods use File | Settings | File Templates.
        BankAccount.mockBankAccountDAO = mockBankAccountDAO;
    }
}
