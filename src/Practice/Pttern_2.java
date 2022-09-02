package Practice;
class Pattern2_Demo{
    void pattern(){
        for (int i=1; i<=4; i++)
        {
            for(int space=3; space>=i; space--)
            {
                System.out.print(" ");
            }
                for(int j=1; j<=i ; j++)
                {
                    System.out.print("*");
                }
                System.out.println();


        }
      for(int i=1;i<=3;i++){
          for(int space=1 ;space<=i;space++){
              System.out.print(" ");
          }
          for(int j=3 ;j>=i;j--){
              System.out.print("*");
          }
          System.out.println();
      }
    }

}
public class Pttern_2
{
    public static void main(String[] args)
    {
     Pattern2_Demo pattern2_demo=new Pattern2_Demo();
     pattern2_demo.pattern();
    }
}
