package Controller;

import DAO.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Validate validate=new Validate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        ServletContext application = getServletContext();
        try {
            if(Validate.checkUser("admin","12345")){
                RequestDispatcher rd=req.getRequestDispatcher("index1.html");
                rd.forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
