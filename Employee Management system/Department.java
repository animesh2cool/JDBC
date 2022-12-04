
public class Department {
    private int Department_ID;
    private String Department_Name;
    private String Department_Head;
    private String Department_Description;

    public int getDepartment_ID() {
        return Department_ID;
    }
    public void setDepartment_ID(int Department_ID) {
        this.Department_ID = Department_ID;
    }
    public String getDepartment_Name() {
        return Department_Name;
    }
    public void setDepartment_Name(String Department_Name) {
        this.Department_Name = Department_Name;
    }
    public String getDepartment_Head() {
        return Department_Head;
    }
    public void setDepartment_Head(String Department_Head) {
        this.Department_Head = Department_Head;
    }
    public String getDepartment_Description() {
        return Department_Description;
    }
    public void setDepartment_Description(String Department_Description) {
        this.Department_Description = Department_Description;
    }

    public Department (int Department_ID,String Department_Name,String Department_Head,String Department_Description) {
        super();
        this.Department_ID = Department_ID;
        this.Department_Name = Department_Name;
        this.Department_Head = Department_Head;
        this.Department_Description = Department_Description;
    }
    public Department (String Department_Name,String Department_Head,String Department_Description) {
        super();
        this.Department_Name = Department_Name;
        this.Department_Head = Department_Head;
        this.Department_Description = Department_Description;
    }
    public Department () {
        super();
    }
}
