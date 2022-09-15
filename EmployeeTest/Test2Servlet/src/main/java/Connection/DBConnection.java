package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection(){


        Connection connection=null;
        String url="jdbc:mysql://localhost:3306/TestEmployee";
        String username="root";
        String password="qwerty123@#";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
               connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
