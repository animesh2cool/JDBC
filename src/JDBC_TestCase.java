import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_TestCase {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // registering mysql driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip", "root", "Khanki4u@");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_mange");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }
            con.close();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
}