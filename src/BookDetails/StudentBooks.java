package BookDetails;

import java.util.Scanner;

public class StudentBooks {
    void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book ID");
        int id = sc.nextInt();
        System.out.println("Enter Book name");
        String name = sc.next();
        System.out.println("Enter publication name");
        String publisher = sc.next();
        System.out.println("Enter Book price");
        float price = sc.nextFloat();
        System.out.println("Enter the author name");
        String author = sc.next();
        Book book=new Book();
        new BookImplementation().addBook(book);

    }

    public static void main(String[] args) {
        while(true) {

              Scanner sc=new Scanner(System.in);
            System.out.println("Enter 1 for insertion 2 for displaying 3 for updation ");
            int i=sc.nextInt();
            switch(i){
                case 1:
            }
        }

    }
}
