package Basics_of_JDBC;// Retrieving data from a MySQL database in a Java program

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        String query = "select * from batch24;";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Loaded Successfully !!!");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String RegNo = rs.getString("RegNo");

                System.out.println();
                System.out.println("========================================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+ name);
                System.out.println("RegNo: "+ RegNo);

            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection Closed Successfully");


        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}