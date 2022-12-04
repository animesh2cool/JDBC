
public class Employee {
    private String Employee_Id;
    private String Employee_Name;
    private String Employee_Address;
    private String Employee_Salary;
    private String Employee_Contact;
    private String Department_Id;

    public String getEmployee_Id() {
        return Employee_Id;
    }
    public void setEmployee_Id(String Employee_Id) {
        this.Employee_Id = Employee_Id;
    }
    public String getEmployee_Name() {
        return Employee_Name;
    }
    public void setEmployee_Name(String Employee_Name) {
        this.Employee_Name = Employee_Name;
    }
    public String getEmployee_Address() {
        return Employee_Address;
    }
    public void setEmployee_Address(String Employee_Address) {
        this.Employee_Address = Employee_Address;
    }
    public String getEmployee_Salary() {
        return Employee_Salary;
    }
    public void setEmployee_Salary(String Employee_Salary) {
        this.Employee_Salary = Employee_Salary;
    }
    public String getEmployee_Contact() {
        return Employee_Contact;
    }
    public void setEmployee_Contact(String Employee_Contact) {
        this.Employee_Contact = Employee_Contact;
    }
    public String getDepartment_Id() {
        return Department_Id;
    }
    public void setDepartment_Id(String Department_Id) {
        this.Department_Id = Department_Id;
    }

    public Employee (String Employee_Id,String Employee_Name,String Employee_Address,String Employee_Salary, String Employee_Contact, String Department_Id) {
        super();
        this.Employee_Id = Employee_Id;
        this.Employee_Name = Employee_Name;
        this.Employee_Address = Employee_Address;
        this.Employee_Salary = Employee_Salary;
        this.Employee_Contact = Employee_Contact;
        this.Department_Id = Department_Id;
    }
}
