package Transaction_Handling_JDBC;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class Transaction_Handling {
    public static void main(String[] args) throws ClassNotFoundException {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ? ";
        String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ? ";


        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Loaded Successfully !!!");
            con.setAutoCommit(false);
            try {
                PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                PreparedStatement depositStatement = con.prepareStatement(depositQuery);
                withdrawStatement.setDouble(1, 500);
                withdrawStatement.setString(2, "account035");
                depositStatement.setDouble(1, 500);
                depositStatement.setString(2, "account123");
                int rowsAffectedWithdrawl = withdrawStatement.executeUpdate();
                int rowsAffectedDeposit = depositStatement.executeUpdate();
                if (rowsAffectedWithdrawl > 0 && rowsAffectedDeposit>0){
                    con.commit();
                    System.out.println("Transaction Successful");
                }else{
                    con.rollback();
                    System.out.println("Transaction Failed");
                }
            }catch(SQLException e) {
                con.rollback();
                System.out.println("Transaction Failed");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
