public class Extra {
    
}

System.out.println("Please Enter pin");
        int pin = s.nextInt();
        try {
            while (rs.next()) {
                xpin = (rs.getInt(7));
                if (xpin == pin) {
                    System.out.println("Enter Deposit Ammount");
                    int addbal = s.nextInt();
                    int nbal = (addbal + rs.getInt(6));
                    PreparedStatement pst1 = con.prepareStatement("update bank set balance = ? where account_no = ? ");
                    pst1.setInt(1, nbal);
                    pst1.setInt(2, acno);
                    pst1.executeUpdate();
                    ResultSet rs1 = pst1.executeQuery("select * from  bank");
                    System.out.println("Updated Balance is : "+rs1.getInt(6));
                }
                else {
                    System.out.println("Invalid pin number");
                }
            }
        }
        catch (Exception e1) {
            System.out.println("Please Try Again");
        }



        Scanner s = new Scanner(System.in);
        System.out.println("Enter A/C no to Show Balance");
        int acno = s.nextInt();
        Connection con = ConnectionApp.con();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from bank");
        try {
            while (rs.next()) {
                xac = (rs.getInt(1));
                if (acno == xac) {
                    System.out.println("Please Enter pin");
                    Connection con1 = ConnectionApp.con();
                    Statement st1 = con1.createStatement();
                    ResultSet rs1 = st1.executeQuery("select * from bank");
                    int pin = s.nextInt();
                    try {
                        while (rs1.next()) {
                            xpin = (rs1.getInt(7));
                            if (xpin == pin) {
                                Statement st2 = con.createStatement();
                                ResultSet rs2 = st2.executeQuery("select * from bank");
                                while (rs2.next()) {
                                    System.out.println("Ypur Balance is : " + rs2.getInt(6));
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("You have entered Wrong Pin Number");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Please Try Again");
        }