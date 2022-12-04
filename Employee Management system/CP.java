import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;
    public static Connection createC() {
        //load the driver
        try {
        Class.forName("com.mysql.jdbc.Driver");
        // create the connection...
        String user = "root";
        String pass = "Khanki4u@";
        String url = "jdbc:mysql://localhost:3306/anudip";
        con = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}