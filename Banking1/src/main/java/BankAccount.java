/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/06/2013
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private BankAccountDAO mBankAccountDAO;
    public BankAccount(BankAccountDAO mBankAccountDAO)
    {
        this.mBankAccountDAO = mBankAccountDAO;
    }
    public void openAccount(String accountNumber) {
        BankAccountDTO mBankAccountDTO = new BankAccountDTO("0123456789");
        mBankAccountDAO.save(mBankAccountDTO);
    }

    public  BankAccountDTO getAccount(String s) {
        return mBankAccountDAO.find(s);
    }
}
