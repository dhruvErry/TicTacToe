import java.util.Scanner;
public class GAME
{
    public static void main()throws Exception{
        Medium o1=new Medium();
        Advanced o2=new Advanced();
        Scanner ISC=new Scanner(System.in);
        System.out.println("Hello, which level do you want to compete with?\n1. Hard\n2. Unbeatable");
        int choice=ISC.nextInt();
        if(choice==1)
            o1.main();
        else if(choice==2)
            o2.main();
        else
            System.out.println("Invalid Choice!");
    }
}
