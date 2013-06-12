/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/06/2013
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO mBankAccountDAO;

    public static void setDAO(BankAccountDAO mBankAccountDAO) {
        BankAccount.mBankAccountDAO = mBankAccountDAO;

    }

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        mBankAccountDAO.save(bankAccountDTO);
        return bankAccountDTO;


    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return mBankAccountDAO.find(accountNumber);

    }

    public static void doTransaction(BankAccountDTO bankAccountDTO,double amount) {

        bankAccountDTO.setBalance(bankAccountDTO.getBalance()+amount);
        mBankAccountDAO.save(bankAccountDTO);
    }
}
