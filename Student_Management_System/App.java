import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management System App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // using buffer class to get response from the user
        while(true) {
            System.out.println("PRESS 1 to ADD Student");
            System.out.println("PRESS 2 to Display Student");
            System.out.println("PRESS 3 to Delete Student");
            System.out.println("PRESS 4 to Update Student");
            System.out.println("PRESS 5 to Exit");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // add student
                System.out.println("Enter Student Name :");
                String name = br.readLine();

                System.out.println("Enter Phone Number :");
                String phone = br.readLine();

                System.out.println("Enter City Name :");
                String city = br.readLine();

                //create student object to store student
                Student st = new Student(name,phone,city);
                Boolean answer = StudentDao.InsertToDB(st);
                if (answer) {
                    System.out.println("Student has been added succsessfully");
                }
                else {
                    System.out.println("Something went wrong");
                }
                System.out.println(st.getStudentName());
            }
            else if (c == 2) {
                // display student
                StudentDao.showAllStudent();
            }
            else if (c == 3) {
                // delete student
                System.out.println("Enter Student ID to delete");
                int userID = Integer.parseInt(br.readLine());
                Boolean f = StudentDao.deleteStudent(userID);
                if(f) {
                    System.out.println("Deleted......");
                }
                else {
                    System.out.println("Something went wrong");
                }
            }
            else if (c == 4) {
                // update student
            }
            else if (c == 5) {
                // exit
                break;
            }
            else {

            }
        }
        System.out.println("Thank You for Using My Application");
    }
}
