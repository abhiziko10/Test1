package BookDetails;

import java.sql.*;
import java.util.Scanner;

public class BookImplementation implements BookInterface {
    Scanner s=new Scanner(System.in);
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    @Override
    public void addBook(Book book) {
        try {

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



    public void updateBook() {
        try {
            showBook();

            System.out.println("Enter Id you want to update");
            int id=s.nextInt();

            PreparedStatement preparedStatement=connection.prepareStatement("update Book_Details set name=? where " +
                    "id=? ");
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
    public void deleteBook()
    {
        try {
            showBook();
            System.out.println("Enter Book id");

            int id=s.nextInt();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Book_Details where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            showBook();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void sortBookByID() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Book_Details order by id desc");
            System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n',"id","name","publisher","price",
                    "author");
            while(resultSet.next())
            {
                System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n',resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3),resultSet.getFloat(4), resultSet.getString(5));

            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void sortBookByPublisher() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select a.publisher, b.author from Book_Details b inner join book a " +
                    "where a.id = b.id order by a.publisher");
            System.out.printf("%-15s" +"%-15s"  +'\n',"publisher", "author" );
            while(resultSet.next())
            {
                System.out.printf("%-15s" +"%-15s"  +'\n',
                        resultSet.getString(1), resultSet.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
