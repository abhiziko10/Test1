package Controller;

import DAO.EmployeeDAO;
import Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        int ID= Integer.parseInt(req.getParameter("ID"));
        String name=req.getParameter("name");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Employee employee=new Employee();
        employee.setID(ID);
        employee.setName(name);
        employee.setUsername(username);
        employee.setPassword(password);
        EmployeeDAO employeeDAO=new EmployeeDAO();
        try{
            employeeDAO.addEmployee(employee);

        }
        catch(Exception e){

        }
        resp.sendRedirect("display");
    }
}
