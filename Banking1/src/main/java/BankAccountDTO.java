import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/06/2013
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {

    private String accountNumber;
    private double balance;
    public BankAccountDTO(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean equals(Object otherAccount) {
        BankAccountDTO other = (BankAccountDTO)otherAccount;
        return accountNumber.equals(other.accountNumber) && ((balance - other.balance) < 0.01);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
