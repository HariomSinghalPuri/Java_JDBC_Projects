package Basics_of_JDBC;// Program For Deletion of Data From MySql through java Program;

import java.sql.*;
public class DeletionData {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        String query = "DELETE FROM batch24 WHERE id = 104;";

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
                System.out.println("Deletion Successfully."+rowsffacted+ "row(s) affected");
            }else{
                System.out.println("Deletion Failed !!!");
            }
            stmt.close();
            con.close();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
