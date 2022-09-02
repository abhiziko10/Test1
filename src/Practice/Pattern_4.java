package Practice;
class Pattern_4_Demo{
    void show(){
        for(int i=1;i<=4;i++) //for rows
        {
            for(int sp=1;sp<=i;sp++)
            {
                System.out.print(" ");  //for spaces
            }
            for(int j=4;j>=i;j--)
            {
                System.out.print("*"); //for stars
            }
            for(int k=3;k>=i;k--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Pattern_4
{
    public static void main(String[] args) {
        Pattern_4_Demo pattern_4_demo=new Pattern_4_Demo();
        pattern_4_demo.show();
    }
}
