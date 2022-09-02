package Practice;
class PatternDemo{
    void P_demo() {
        for (int i = 1; i <= 4 ; i++){
            for(int j=1 ;j<=i ; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        for(int i=1; i<=3;i++){
            for(int j=3; j>=i; j--){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
public class Pattern {
    public static void main(String[] args) {
        PatternDemo patternDemo=new PatternDemo();
        patternDemo.P_demo();
    }
}
