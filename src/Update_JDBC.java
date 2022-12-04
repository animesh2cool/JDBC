import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_JDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // registering mysql driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip", "root", "Khanki4u@");
            Statement st = con.createStatement();
            //updating database
            st.executeUpdate("update student_mange set sadd='WestBengal' where Sid=2");
            st.executeUpdate("delete from student_mange where Sid=5");
            //execute
            ResultSet rs = st.executeQuery("select * from student_mange");
            //printing updated database
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
