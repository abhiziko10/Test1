package Practice;
class Pattern3_Demo{
    void display() {
        for (int i = 1; i <= 4; i++)
        {
            for(int space=3; space>=i; space--)
            {
                System.out.print(" ");
            }
                for(int j=1; j<=i; j++){
                    System.out.print(" *");
                }
                System.out.println();

        }
    }
}
public class Pattern_3 {
    public static void main(String[] args) {
        Pattern3_Demo pattern_3=new Pattern3_Demo();
        pattern_3.display();
    }
}
