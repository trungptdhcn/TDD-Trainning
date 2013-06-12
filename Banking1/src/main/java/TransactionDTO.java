import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 11/06/2013
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    private String accountNumber;
    private double amount;
    private String description;
    private long timeStamp;
    public TransactionDTO(String accountNumber,double amount,String description,long timeStamp)
    {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
        this.timeStamp = timeStamp;
    }
    public static void setCalender(Calendar c)
    {
        c = Calendar.getInstance();
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
