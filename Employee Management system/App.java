import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Employee Database Management App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // using buffer class to get response from the user
        while(true) {
            System.out.println("PRESS 1 to Store Department Details");
            System.out.println("PRESS 2 to Store Employee Details");
            System.out.println("PRESS 3 to Exit");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // add Department
                System.out.println("Enter Department ID  :");
                int id = br.read();

                System.out.println("Enter Department Name :");
                String dname = br.readLine();

                System.out.println("Enter Department Head :");
                String dhead = br.readLine();

                System.out.println("Enter Department Description :");
                String desc = br.readLine();

                //create Employee object to store student
                Department dpt = new Department(id,dname,dhead,desc);
                Boolean answer = DepartmentUploader.InsertToDB(dpt);
                if (answer) {
                    System.out.println("Department has been added succsessfully");
                }
                else {
                    System.out.println("Something went wrong");
                }
                System.out.println(dpt.getDepartment_Name());
            }
            else if (c == 2) {
                // Add Employee
                System.out.println("Enter Employee Id :");
                String eid = br.readLine();

                System.out.println("Enter Employee Name :");
                String ename = br.readLine();

                System.out.println("Enter Employee Address :");
                String eadd = br.readLine();

                System.out.println("Enter Employee Salary :");
                String esal = br.readLine();

                System.out.println("Enter Employee Contact :");
                String econt = br.readLine();

                System.out.println("Enter Department Id :");
                String id = br.readLine();

                //create Employee object to store student
                Employee emp = new Employee(eid,ename,eadd,esal,econt,id);
                Boolean answer = EmployeeUploader.InsertToDB(emp);
                if (answer) {
                    System.out.println("Employee has been added succsessfully");
                }
                else {
                    System.out.println("Something went wrong");
                }
                System.out.println(emp.getEmployee_Name());
                }
            else if (c == 3) {
                break;
            }
            else {

            }
            
        }
        System.out.println("Thank You for Using My Application");
    }
}
