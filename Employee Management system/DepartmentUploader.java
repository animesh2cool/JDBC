import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepartmentUploader {
    public static boolean InsertToDB(Department dpt) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "insert into Department1(Department_ID,Department_Name,Department_Head,Department_Description) values(?,?,?,?)";
            //prepare statement
            PreparedStatement pst = con.prepareStatement(q);
            //set the value of parameter
            pst.setInt(1, dpt.getDepartment_ID());
            pst.setString(2, dpt.getDepartment_Name());
            pst.setString(3, dpt.getDepartment_Head());
            pst.setString(4, dpt.getDepartment_Description());
            //execute
            pst.executeUpdate();
            f = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
