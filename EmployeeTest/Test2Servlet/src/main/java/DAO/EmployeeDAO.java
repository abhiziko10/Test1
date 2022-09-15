package DAO;

import Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connection.DBConnection;
public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        int i = 0;
        String string = "insert into Employee(ID,name,username,password)values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setInt(1, employee.getID());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public Boolean updateEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        String string = "Update Employee set  name=? username=? password=?";
        string += "where id=?";
        int i = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getUsername());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setInt(4, employee.getID());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }


    public void deleteEmployee(int ID) {
        Connection connection = DBConnection.getConnection();
        String string = "Delete from Employee where ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Employee> showEmployee() {
        List<Employee> employee = new ArrayList<Employee>();
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Employee");
            while (resultSet.next()) {
                Employee employee1 = new Employee();
                employee1.setID(resultSet.getInt("ID"));
                employee1.setName(resultSet.getString("name"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}