package Basics_of_JDBC;//  INSERT Data into Database ;

import java.sql.*;

public class InsertingData {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        String query = "INSERT INTO batch24(id,name,RegNo) VALUES (102,'Ram Kumar','24MIM10007');";

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
                System.out.println("Insertion Successfully."+rowsffacted+ "row(s) affected");
            }else{
                System.out.println("Insertion Failed !!!");
            }
            stmt.close();
            con.close();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
