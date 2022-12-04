import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insertjdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // registering mysql driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip", "root", "Khanki4u@");
            Statement st = con.createStatement();               //statement
            st.executeUpdate("insert into student_mange values (1,'Animesh',12345678,'Kolkata')");
            st.executeUpdate("insert into student_mange values (2,'Devkanta',675998,'Kolkata')");
            st.executeUpdate("insert into student_mange values (3,'Arnob',225409,'Kolkata')");

            System.out.println("data inserted successfully");
            con.close();
            st.close();
        }
        catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
