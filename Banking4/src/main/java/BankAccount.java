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
}
