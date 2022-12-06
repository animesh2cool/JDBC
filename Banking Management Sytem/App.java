import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.lang.Exception;

public class App {
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

            while (true) {
            System.out.println("**********************************");
			System.out.println("Welcome To Banking Management System");
			System.out.println("**********************************");
            System.out.println("press 1 for create Account");
		    System.out.println("press 2 for deposit");
		    System.out.println("press 3 for withdraw");
		    System.out.println("press 4 for show balance");
		    System.out.println("press 5 for pin change");
		    System.out.println("press 6 for close account");
		    System.out.println(" press 7 for exit");
            int c = s.nextInt();

            if (c == 1) {
                BankOperation.createAC();
            }
            else if (c == 2) {
                BankOperation.deposit();
            }
            else if (c == 3) {
                BankOperation.withdraw();
            }
            else if (c == 4) {
                BankOperation.showbalance();
            }
            else if (c == 5) {
                BankOperation.pinchange();
            }
            else if (c == 6) {
                BankOperation.closeaccount();
            }
            else if (c == 7) {
                break;
            }
            else {
                    System.out.println("Invalid Input please try again");
            }
            }
        }
    }

