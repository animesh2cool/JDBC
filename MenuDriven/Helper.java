import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Helper {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // registering my sql driver
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection con() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip", "root", "Khanki4u@");
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        MenuDrivrneg menu = new MenuDrivrneg();
        
        while (true) {
            System.out.println("PRESS 1 to ADD Employee");
            System.out.println("PRESS 2 to Display Employee");
            System.out.println("PRESS 3 to Delete Employee");
            System.out.println("PRESS 4 to Update Employee");
            System.out.println("PRESS 5 to Exit");
            int c = s.nextInt();

            if (c == 1) {
                menu.savemenudriven();
            }
            else if (c == 2) {
                menu.fetchMenudriven();
            }
            else if (c == 3) {
                menu.deletemenudriven();
            }
            else if (c == 4) {
                menu.updatemenudriven();
            }
            else if (c == 5) {
                break;
            }
            else {

            }
        }
    }
}
