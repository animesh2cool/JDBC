import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckAccount {
    public static boolean check(int acno) throws Exception {
        Boolean result = false;
        Statement st = ConnectionApp.con().createStatement();
        ResultSet rs = st.executeQuery("select * from bank where account_no="+acno);
        if (rs.next()) {
            result = true;
        }
        else {
            result = false;
        }
        rs.close();
        st.close();
        return result;
    }
    public static boolean checkpass (int pin, int acno) throws Exception {
        Boolean result = false;
        Statement st = ConnectionApp.con().createStatement();
        ResultSet rs = st.executeQuery("select pin from bank where account_no="+acno);
        rs.next();
        int oldpin = rs.getInt(1);
        if (oldpin == pin) {
            result = true;
        }
        else {
            result = false;
        }
        rs.close();
        st.close();
        return result;
    }
}
