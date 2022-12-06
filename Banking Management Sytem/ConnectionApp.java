import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionApp {
	

	public static Connection con() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip", "root", 									"Khanki4u@");      // establish connection
	}

}