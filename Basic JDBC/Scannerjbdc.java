import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Scannerjbdc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This app is for Data Entry");
        System.out.println("Please enter Student ID : ");
        String sid = s.next();
        System.out.println("Please enter Student Name : ");
        String sname = s.next();
        System.out.println("Please enter Student phone : ");
        String sphone = s.next();
        System.out.println("Please enter Student Address : ");
        String sadd = s.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // registering mysql driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip", "root", "Khanki4u@");
            String sql = "insert into student_mange values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);          //prepare statement
            pst.setString(1, sid);
            pst.setString(2, sname);
            pst.setString(3, sphone);
            pst.setString(4, sadd);
            pst.execute();
            System.out.println("Data inserted");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
