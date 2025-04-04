package Basics_of_JDBC;// Program For Update of Data From MySql through java Program;

import java.sql.*;
public class UpdatingData {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        String query = "UPDATE batch24 SET name = 'Hariom Singhal Puri' WHERE name = 'Hariom Puri';";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Loaded Successfully !!!");
            Statement stmt = con.createStatement();
            int rowsffacted = stmt.executeUpdate(query);
            if(rowsffacted>0){
                System.out.println("Update Successfully."+rowsffacted+ "row(s) affected");
            }else{
                System.out.println("Updating Failed !!!");
            }
            stmt.close();
            con.close();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
