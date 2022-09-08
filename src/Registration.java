import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String FirstName=req.getParameter("FirstName");
        String LastName=req.getParameter("LastName");
        String MobileNo=req.getParameter("MobileNo");
        String City=req.getParameter("City");
        String Education=req.getParameter("Education");
        String password=req.getParameter("password");
           if(FirstName.matches("[a-zA-Z]+") && LastName.matches("[a-zA-Z]+") && MobileNo.matches("[0-9]+")&& City.matches("[a-zA-Z]+")&& Education.matches("[a-zA-Z]+"))
           {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Verification","root",
                           "qwerty123@#");
                   //loading drivers for mysql
                   PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
                   ps.setString(1,FirstName);
                   ps.setString(2,LastName);
                   ps.setString(3,MobileNo);
                   ps.setString(4,City);
                   ps.setString(5,Education);
                   ps.setString(6,password);
                   if(ps.execute())
                   {
                       out.println("You are successefully registered");
                       RequestDispatcher requestDispatcher=req.getRequestDispatcher("index1.html");
                       requestDispatcher.include(req,resp);
                       out.println("Welcome");
                   }

                   ResultSet rs= ps.getResultSet();

               } catch (SQLException e) {
                   throw new RuntimeException(e);
               } catch (ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
               RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login");
               requestDispatcher.forward(req,resp);
               out.println("Welcome");
           }
           else
           {
               out.println("Invalid Credentials");
           }
    }
}
