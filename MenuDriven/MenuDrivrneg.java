import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDrivrneg {
    static int eid, eage, esalary;
    static String ename, ecity;
    Scanner s = new Scanner(System.in);
// saving employee details
    public void savemenudriven() throws SQLException {
        System.out.println(" Enter Employee ID");
        eid = s.nextInt();
        System.out.println(" Enter Employee Name");
        ename = s.next();
        System.out.println(" Enter Employee Age");
        eage = s.nextInt();
        System.out.println(" Enter Employee City");
        ecity = s.next();
        System.out.println(" Enter Employee Salary");
        esalary = s.nextInt();
//Connecting to the DataBase
        Connection con = Helper.con();
        PreparedStatement pst = con.prepareStatement("insert into menudriven values (?,?,?,?,?)");
        pst.setInt(1, eid);
        pst.setString(2, ename);
        pst.setInt(3, eage);
        pst.setString(4, ecity);
        pst.setInt(5, esalary);
        pst.executeUpdate();
    }
// fetching Data from Database
    public void fetchMenudriven() throws SQLException {
        Connection con = Helper.con();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from menudriven");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getInt(3)+ " " + rs.getString(4) + " "+ rs.getInt(5));
        }
    }
// Updating Database
    public void updatemenudriven() throws SQLException {
        Connection con = Helper.con();
        System.out.println("Enter Employee ID to Update");
        int ueid = s.nextInt();
        System.out.println("Enter city for update");
        String ucity = s.next();
        PreparedStatement pst = con.prepareStatement("update menudriven set ecity = ? where eid = ?");
        pst.setInt(2, ueid);
        pst.setString(1, ucity);
        pst.executeUpdate();
    } 
    public void deletemenudriven() throws SQLException {
        Connection con = Helper.con();
        System.out.println("Enter Employee ID to Delete");
        int deid = s.nextInt();
        PreparedStatement pst = con.prepareStatement("delete from menudriven where eid = ?");
        pst.setInt(1, deid);
        pst.executeUpdate(); 
    }
}
