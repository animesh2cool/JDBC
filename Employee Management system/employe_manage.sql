use anudip;

create table Department ( Department_ID numeric primary key , Department_Name varchar(20), Department_Head varchar(30), Department_Description varchar (1000));

create table Employee (Employee_Id numeric(10) primary key, 
						Employee_Name varchar(30) , 
                        Employee_Address varchar(100) , 
                        Employee_Salary decimal(5) 
                        check (1000 < Employee_Salary < 1000000) , 
                        Employee_Contact_No numeric(15), 
                        Department_Id numeric(10), 
						constraint frk_key 
                        Foreign Key (Department_Id) references Department(Department_ID));