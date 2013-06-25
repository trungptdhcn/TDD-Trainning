import com.mysql.jdbc.Connection;
import org.junit.Before;
import org.junit.BeforeClass;

import java.mysql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 25/06/2013
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccountDAO {
    private static Connection connection = null;
    private static String USER = "root";
    private static String PASS = "thuyanh";
    private static String url = "jdbc:mysql://127.0.0.1/test";

    @BeforeClass
    public static void createSchema() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, USER, PASS);
        }
    }
}
