package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DBConnection;
@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    Connection connection= DBConnection.getConnection();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();
            Statement statement=connection.createStatement();
            ResultSet rs=connection.createStatement().executeQuery("Select * from employee");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>ID</th><th>name</th><th>username</th><th>password</th>");
            while(rs.next()){
                int ID=rs.getInt(1);
                String name=rs.getString(2);
                String username=rs.getString(3);
                String password=rs.getString(4);

                out.println("<tr><td>"+ID+"<td></td>"+name+"</td><td>"+username+"</td><td>"+password+"</td></tr>");
            }
            out.println("</table>");
            out.println(" <a href=index1.html>AddEmployee</a>");
            out.println("</html></body>");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
