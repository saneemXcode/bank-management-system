import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// this is the test for github

//this is the second test
public class CreateDb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "miza";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "saneem@123";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();

            String createDBQuery = "CREATE DATABASE " + dbName;
            statement.executeUpdate(createDBQuery);
            System.out.println("Database created successfully");

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
