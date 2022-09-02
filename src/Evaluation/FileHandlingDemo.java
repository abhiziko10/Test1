package Evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("Abhishek.txt");
         try{
             file.createNewFile();
         }catch(IOException e){
             e.printStackTrace();

         }
        FileWriter fileWriter=new FileWriter("Abhishek.txt");
         fileWriter.write(" I am genius");
         fileWriter.write("\n I am confident");
         fileWriter.write("\n I love myself");
         fileWriter.close();
        System.out.println(file.exists());

         try{
             Scanner sc=new Scanner(file);
             while(sc.hasNext()){
                 String line= sc.nextLine();
                 System.out.println(line);
             }


         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         }

    }



}
