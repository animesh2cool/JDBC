import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class StudentDao {
    public static boolean InsertToDB(Student st) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "insert into students(sname,sphone,scity) values(?,?,?)";
            //prepare statement
            PreparedStatement pst = con.prepareStatement(q);
            //set the value of parameter
            pst.setString(1, st.getStudentName());
            pst.setString(2, st.getStudentPhone());
            pst.setString(3, st.getStudentCity());
            //execute
            pst.executeUpdate();
            f = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userID) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "delete from students where sid = ?";
            //prepare statement
            PreparedStatement pst = con.prepareStatement(q);
            //set the value of parameter
            pst.setInt(1, userID);
            //execute
            pst.executeUpdate();
            f = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudent() {
        try {
            Connection con = CP.createC();
            String q = "select * from students;";
            //prepare statement
            PreparedStatement pst = con.prepareStatement(q);
            Statement stm = con.createStatement();

            ResultSet set = stm.executeQuery(q);

            while(set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);

                System.out.println("Student ID : "+id);
                System.out.println("Student Name : "+name);
                System.out.println("Phone : "+phone);
                System.out.println("City : "+city);
                System.out.println("--------------------------------------");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
