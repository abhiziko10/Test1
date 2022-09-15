package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
public class Validate {

    public static Boolean checkUser(String username,String password) throws SQLException {
         boolean status=false;
        Connection connection= DBConnection.getConnection();

        PreparedStatement ps = connection.prepareStatement("select * from user where username=? and password=?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs =ps.executeQuery();
        status=rs.next();


        return true;
    }

}
