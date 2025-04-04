package Prepared_Statement;
import java.sql.*;

public class Prepared_Statement {
    public static void main(String[] args) throws ClassNotFoundException {
        // Database URL
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "#Ep31ub5bsk@";
        //String query = "SELECT * from employees where name = ? ";
        String query = "SELECT * from employees where name = ? AND job_title= ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Loaded Successfully !!!");
            Statement statement = con.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,"Hariom");
            preparedStatement.setString(2,"Software Developer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID:"+ id);
                System.out.println("NAME:"+ name);
                System.out.println("JOB TITLE:"+ job_title);
                System.out.println("SALARY:"+ salary);
            }
            resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println("Connection Closed Successfully");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}