package Banking_Mangement_System.Batch_Processing;

import java.sql.*;

public class BatchProcessing {
    public static void main(String[] args) throws ClassNotFoundException {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        String sql = "INSERT INTO employeeslist (id, first_name, last_name) VALUES (?, ?, ?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // First record
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Alice");
            pstmt.setString(3, "Brown");
            pstmt.addBatch();

            // Second record
            pstmt.setInt(1, 102);
            pstmt.setString(2, "Bob");
            pstmt.setString(3, "Green");
            pstmt.addBatch();

            // Execute batch
            int[] updateCounts = pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
