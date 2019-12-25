import java.util.Scanner;
public class Main
{
    public static void main(String []args)throws Exception{
        Medium o1=new Medium();
        Advanced o2=new Advanced();
        Scanner ISC=new Scanner(System.in);
        System.out.println("WELCOME TO ERRY'S TIC TAC TOE GAME!\n");
        System.out.println("Which level do you want to compete with?\n1. Hard\n2. Unbeatable");
        int choice=ISC.nextInt();
        if(choice==1)
            o1.main(new String[]{"a"});
        else if(choice==2)
            o2.main(new String[]{"a"});
        else
            System.out.println("Invalid Choice!");
    }
}
