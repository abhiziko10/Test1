package BookDetails;

import java.sql.*;
import java.util.Scanner;

public class BookImplementation implements BookInterface,Connectivity {
    @Override
    public void addBook(Book book) {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
             PreparedStatement preparedStatement=connection.prepareStatement("insert into Book_Details values(?,?,?" +
                     "?,?");
             preparedStatement.setInt(1,book.id);
             preparedStatement.setString(2,book.name);
             preparedStatement.setString(3,book.publisher);
             preparedStatement.setFloat(4,book.price);
             preparedStatement.setString(5,book.author);
            }
        catch(Exception e)
        {

            e.printStackTrace();
        }
    }

    @Override
    public void showBook() {
        try{
            Connection connection=DriverManager.getConnection(url,username,password );
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from Book_Details");
            System.out.printf("%-10s"+ "%-20s" + "%-20s"+ "%-20s"+"%-20s\n","id","name","publisher","price","author");
            while(resultSet.next())
            {
                System.out.printf("%-10s"+ "%-20s"+ "%-20s"+ "%-20s"+ '\n',resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getString(3),resultSet.getFloat(4),resultSet.getString(5));

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook() {

    }

    public void updateBook() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner s=new Scanner(System.in);
            System.out.println("Enter Id you want to update");
            int id=s.nextInt();
            System.out.println();
            PreparedStatement preparedStatement=connection.prepareStatement("update book set name=? where id=? ");
            System.out.println("Enter book name");
            String name=s.next();
            preparedStatement.setInt(2,id);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void delete()
    {

    }
}
