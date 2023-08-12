
import java.sql.*;

public class Conn {
    Connection c;// connection
    Statement s;// create statement

    public Conn() {

        try {
            c = DriverManager.getConnection("jdbc:mysql: ///bankmanagementsystem", "root", "saneem@123");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
