package Image_Handling_JDBC;
import java.io.*;
import java.sql.*;


public class Image_Handling {
        public static void main(String[] args) throws ClassNotFoundException {
            // Database URL
            String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
            String username = "root";
            String password = "#Ep31ub5bsk@";
            //Folder name is used on time of Retriveing data from source
            String folder_path = "C:\\Users\\wwwsi\\Pictures\\";
            //String image_path = "C:\\Users\\wwwsi\\Pictures\\bunny.jpeg";

            // Use on time on Insertion of image in a database:
            //String query = "INSERT INTO image_table(image_data) VALUES(?)";

            // Use on Time of Retriving data
            String query = "SELECT image_data from image_table where image_id = (?)";


            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Drivers Loaded Successfully");
            }catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            try {
                Connection con = DriverManager.getConnection(url,username,password);
                System.out.println("Connection Loaded Successfully !!!");

                //This is for Input image data
//                FileInputStream fileInputStream = new FileInputStream(image_path);
//                byte[] imageData = new byte[fileInputStream.available()];
//                fileInputStream.read(imageData);
//                PreparedStatement preparedStatement = con.prepareStatement(query);
//                preparedStatement.setBytes(1,imageData);
//                int affectedRows = preparedStatement.executeUpdate();
//                if(affectedRows>0){
//                    System.out.println("Image Inserted Successfully");
//                }
//                else {
//                    System.out.println("Image Not Inserted");
//                }
//

                //This is for Output of Image in Same Folder we Input:

                PreparedStatement preparedStatement= con.prepareStatement(query);
                preparedStatement.setInt(1,1);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    byte[] image_data = resultSet.getBytes("image_data");
                    String image_path = folder_path+"ExtractedImage.jpg";
                    OutputStream outputStream = new FileOutputStream(image_path);
                    outputStream.write(image_data);
                }else{
                    System.out.println("Image Not Found");
                }

            } catch (SQLException e){
                System.out.println(e.getMessage());
            }catch (FileNotFoundException e){
                throw new RuntimeException(e);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
}
