package Controller;

import DAO.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        int ID= Integer.parseInt(req.getParameter("ID"));

        EmployeeDAO employeedao =new EmployeeDAO();
        try{
            employeedao.deleteEmployee(ID);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
