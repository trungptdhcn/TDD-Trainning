/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private double balance;
    private String accountNumber;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
