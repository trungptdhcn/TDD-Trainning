import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 11/06/2013
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    Calendar c = Calendar.getInstance() ;
    String accountNumber;
    double amount;
    String description;
    long timeStamp ;
    public TransactionDTO()
    {

    }
    public TransactionDTO(long timeStamp,String accountNumber,double amount,String description)
    {
       this.timeStamp = timeStamp;
       this.accountNumber = accountNumber;
       this.amount = amount;
       this.description = description;

    }

    public long getTimeStamp() {
        return timeStamp;
    }
    public void setC(Calendar c)
    {
        this.c = c;

    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
