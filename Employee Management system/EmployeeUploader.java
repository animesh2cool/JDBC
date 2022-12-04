import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeUploader {

    public static boolean InsertToDB(Employee emp) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "insert into Employee(Employee_Id,Employee_Name,Employee_Address,Employee_Salary,Employee_Contact_No,Department_Id) values(?,?,?,?,?,?)";
            //prepare statement
            PreparedStatement pst = con.prepareStatement(q);
            //set the value of parameter
            pst.setString(1, emp.getEmployee_Id());
            pst.setString(2, emp.getEmployee_Name());
            pst.setString(3, emp.getEmployee_Address());
            pst.setString(4, emp.getEmployee_Salary());
            pst.setString(5, emp.getEmployee_Contact());
            pst.setString(6, emp.getDepartment_Id());
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
