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
    private Date openTimestampt;
    public BankAccountDTO(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenTimestampt() {
        return openTimestampt;
    }

    public void setOpenTimestampt(Date openTimestampt) {
        this.openTimestampt = openTimestampt;
    }

}
