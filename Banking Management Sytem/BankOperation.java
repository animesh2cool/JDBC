import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BankOperation {
    static int xac;
    static int count;
    static String actype;

    public static void createAC() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter a A/C number");
        int acno = s.nextInt();
        System.out.println("Please Enter Customer Name");
        String cname = s.next();
        System.out.println("Please Enter a IFSC code");
        String ifsc = s.next();
        System.out.println("Please Enter Branch");
        String branch = s.next();
        System.out.println("Please Enter a Customer pin");
        int pin = s.nextInt();
        System.out.println("Chose A/C Type : 1 for savings 2 for Current");
        int type = s.nextInt();
        if (type == 1) {
            actype = "savings";
        } else if (type == 2) {
            actype = "Current";
        }
        System.out.println("Please Enter Opening Balance");
        int bal = s.nextInt();
        Connection con = ConnectionApp.con();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from bank");
        try {
            while (rs.next()) {
                xac = (rs.getInt(1));
                if (acno == xac) {
                    System.out.println("A/C no Already Exist");
                }
            }
            PreparedStatement pst = con.prepareStatement("insert into bank values (?,?,?,?,?,?,?)");
            pst.setInt(1, acno);
            pst.setString(2, cname);
            pst.setString(3, ifsc);
            pst.setString(4, branch);
            pst.setString(5, actype);
            pst.setInt(6, bal);
            pst.setInt(7, pin);
            pst.executeUpdate();
            System.out.println("A/C has been opened");
        } catch (Exception e) {
            System.out.println("Try Again");
        }
    }

    public static void deposit() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter A/C no to Deposit :");
        int acno = s.nextInt();
        Connection con = ConnectionApp.con();
        if (CheckAccount.check(acno)) {
            System.out.println("Please Enter Pin :");
            if (CheckAccount.checkpass(new Scanner(System.in).nextInt(), acno)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select balance from bank");
                rs.next();
                System.out.println("Enter Deposit Ammount :");
                int addbal = s.nextInt();
                int nbal = (addbal + rs.getInt(1));
                PreparedStatement pst = con.prepareStatement("update bank set balance = ? where account_no =" + acno);
                pst.setInt(1, nbal);
                pst.executeUpdate();
                System.out.println("Your A/C has been Credited with INR " + addbal + " and your New balance is INR " + nbal);
            } else {
                System.out.println("Wrong Pin Number Please try again");
                deposit();
            }
        } else {
            System.out.println("This is not a valid A/C number");
            deposit();
        }
    }

    public static void withdraw() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter A/C no to withdraw :");
        int acno = s.nextInt();
        Connection con = ConnectionApp.con();
        if (CheckAccount.check(acno)) {
            System.out.println("Please Enter Pin :");
            if (CheckAccount.checkpass(new Scanner(System.in).nextInt(), acno)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select balance from bank");
                rs.next();
                System.out.println("Enter Withdrwal Ammount");
                int wbal = s.nextInt();
                if (wbal <= rs.getInt(1)) {
                    int nbal = (rs.getInt(1)-wbal);
                    PreparedStatement pst = con.prepareStatement("update bank set balance = ? where account_no =" + acno);
                    pst.setInt(1, nbal);
                    pst.executeUpdate();
                    System.out.println("Your A/C has been Debited with INR " + wbal + " and your New balance is INR " + nbal);
                } else {
                    System.out.println("You have insufficient funds");
                }
            } else {
                System.out.println("Wrong Pin Number Please try again");
                withdraw();
            }
        } else {
            System.out.println("This is not a valid A/C");
            withdraw();
        }
    }

    public static void showbalance() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter A/C no to Check Balance :");
        int acno = s.nextInt();
        Connection con = ConnectionApp.con();
        if (CheckAccount.check(acno)) {
            System.out.println("Please Enter Pin :");
            if (CheckAccount.checkpass(new Scanner(System.in).nextInt(), acno)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select balance from bank where account_no =" + acno);
                rs.next();
                System.out.println("Your Current balance is INR " + rs.getInt(1));
            } else {
                System.out.println("Wrong Pin Number Please try again");
                showbalance();
            }
        } else {
            System.out.println("This is not a valid A/C number");
            showbalance();
        }
    }
    public static void pinchange() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter A/C no to Change Pin :");
        int acno = s.nextInt();
        Connection con = ConnectionApp.con();
        if (CheckAccount.check(acno)) {
            System.out.println("Please Enter Previous Pin :");
            if (CheckAccount.checkpass(new Scanner(System.in).nextInt(), acno)) {
                System.out.println("Please Enter New Pin :");
                int newpin = s.nextInt();
                PreparedStatement pst = con.prepareStatement("update bank set pin = ? where account_no = ?");
                pst.setInt(1, newpin);
                pst.setInt(2, acno);
                pst.executeUpdate();
                System.out.println("Your New Pin has ben set you can login with your new pin");
            }
            else {
                System.out.println("Wrong Pin Number Please try again");
                pinchange();
            } 
            }else {
            System.out.println("This is not a valid A/C number");
            pinchange();
        }
    }
    public static void closeaccount() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter A/C no to Close Account :");
        int acno = s.nextInt();
        Connection con = ConnectionApp.con();
        if (CheckAccount.check(acno)) {
            System.out.println("Please Enter Pin to close your A/C :");
            if (CheckAccount.checkpass(new Scanner(System.in).nextInt(), acno)) {
                PreparedStatement pst = con.prepareStatement("delete from bank where account_no = ?");
                pst.setInt(1, acno);
                pst.executeUpdate();
                System.out.println("Your A/C has been successfully deleted");
            }
            else {
                System.out.println("Wrong Pin Number Please try again");
                closeaccount();
            } 
            }else {
            System.out.println("This is not a valid A/C number");
            closeaccount();
        }
    }
}