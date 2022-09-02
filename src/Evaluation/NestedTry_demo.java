package Evaluation;

import jdk.swing.interop.SwingInterOpUtils;

class NestedDemo {
    void ExceptionTest1() {
        String name = null;

        try {
            try {
                Object obj = new Object();
                Integer integer = (Integer) obj;
            } finally {
                System.out.println("Invalid choice");
            }

        }
        catch(ClassCastException e)
        {
            e.printStackTrace();
        }
    }
}
class problem{
    void ExceptionTest(){
        String name=null;
        try{
            try{
                Object obj=new Object();
                Integer integer=(Integer)obj;

            }catch(ClassCastException e){

                e.printStackTrace();
            }
            name.length();
        }catch(NullPointerException e){
            e.printStackTrace();
        }


    }
}
public class NestedTry_demo {


    public static void main(String[] args) {

        problem p=new problem();
        p.ExceptionTest();
        System.out.println("CASE1 OUTPUT");
        NestedDemo nestedDemo=new NestedDemo();
        nestedDemo.ExceptionTest1();
        System.out.println("CASE2 OUTPUT");
    }
}
