import java.util.*;
public class Medium
{
    static char[][]board=new char[4][4];
    static int a, b,p1,p2, comp, yooz, countTwo=0;
    static boolean further, play, me;
    static boolean one=false;
    static boolean two=false;
    static Scanner yo=new Scanner(System.in);
    static char my=(char)9747;
    static char opp=(char)9675;
    static char p1temp,count, first;
    public Medium()throws Exception{        
        yo=new Scanner(System.in);
        play=true;
        further=true;
        p1=0;
        p2=0;
        p1temp=0;
        count=0;
        first=0;
        opp=(char)9675;
        my=(char)9747;
    }
    
    public static void fill()throws Exception{
        a=0;
        b=0;
        while(a<4){
            b=0;
            while (b<4){
                board[a][b]='\u3000';
                b++;
            }
            a++;
        }
        board[0][0]=(char)12320;
        board[0][1]=(char)9398;
        board[0][2]=(char)9399;
        board[0][3]=(char)9400;
        board[1][0]=(char)9461;
        board[2][0]=(char)9462;
        board[3][0]=(char)9463;
    }

    public static void printScores()throws Exception{
        System.out.println("Computer: "+comp);
        System.out.println("User:     "+yooz);
    }

    public static void again()throws Exception{
        System.out.println("Would you like to play again?\n1 for yes and 2 for no:");
        int h=yo.nextInt();
        if(h==1){
            countTwo++;
            play=true;
            main(new String[]{"a"});
        }
        else{
            System.out.println("Thank you for playing Erry's Game!");
            System.exit(0);
        }
    }

    public static void printBoard()throws Exception{
        a=0;
        b=0;
        while (a<4){
            b=0;
            while (b<4){
                System.out.print("|"+board[a][b]+"|");
                b++;
            }
            System.out.println();
            a++;
        }
    }

    public static void youPlay()throws Exception{
        further=true;
        if(one||two){
            two=false;
            firstMove();
        }
        if(play){
            printBoard();
            System.out.println("Your Turn!");
            String turn=yo.next();
            char p1temp=turn.charAt(0);
            if(p1temp=='A'||p1temp=='a')
                p1=1;
            else if(p1temp=='B'||p1temp=='b')
                p1=2;
            else if(p1temp=='C'||p1temp=='c')
                p1=3;
            p2=turn.charAt(1)-'0';
            if(board[p2][p1]=='\u3000'){
                board[p2][p1]=opp;
                printBoard();
            }
            else{
                System.out.println("That spot is taken!");
                youPlay();
            }
            if(whoWin(my)){
                further=false;
                System.out.println("\nYou Lose!");
                comp+=3;
                printScores();
                play=false;
                again();
            }
            if(further)
                if(whoWin(opp)){
                    further=false;
                    System.out.println("\nYou Win!");
                    yooz+=3;
                    printScores();
                    play=false;
                    again();
                }
            if(further)
                if(draw()){
                    further=false;
                    comp++;
                    yooz++;
                    System.out.println("The match-up has ended as a draw!");
                    printScores();
                    again();
                }            
            if(further){
                System.out.println();
                System.out.print("Thinking.");
                Thread.sleep(567);
                System.out.print(".");
                Thread.sleep(608);
                System.out.println(".");
                System.out.println();
            }
            if(further)
                someoneWin(my);
            if(further)
                someoneWin(opp);
            if(further)
                firstMove();
            if(further)
                random();
        }
    }

    public static void iPlay(int x, int y)throws Exception{
        board[x][y]=my;
        if(play&&whoWin(my)){
            printBoard();
            System.out.println("\nYou Lose!");
            comp+=3;
            printScores();
            play=false;
            again();
        }
        else if(play&&draw()){
            further=false;
            printBoard();
            comp++;
            yooz++;
            System.out.println("The match-up has ended as a draw!");
            printScores();
            again();
        }
        youPlay();
    }

    public static boolean draw(){
        a=1;
        b=1;
        while(a<4){
            b=1;
            while (b<4){
                if(board[a][b]=='\u3000')
                    return false;
                b++;
            }
            a++;
        }
        return true;
    }

    public static void someoneWin(char f)throws Exception{
        boolean goOn=true;
        a=1;
        b=1;
        count=0;
        while (a<4&&goOn){
            b=1;
            count=0;
            while (b<4){
                if(board[a][b]==f)
                    count++;
                else if(board[a][b]!='\u3000')
                    count=0;
                if (count==2)
                    break;
                else
                    b++;
            }
            if(count==2){
                b=1;
                while (b<4){
                    if(board[a][b]=='\u3000'){
                        further=false;
                        goOn=false;
                        break;
                    }
                    b++;
                }
                if(!further&&!goOn)
                    iPlay(a,b);
            }
            a++;
        }
        a=1;
        b=1;
        count=0;
        while (a<4&&goOn){
            b=1;
            count=0;
            while (b<4){
                if(board[b][a]==f)
                    count++;
                else if(board[b][a]!='\u3000')
                    count=0;
                if (count==2)
                    break;
                else
                    b++;
            }
            if(count==2){
                b=1;
                while (b<4&&goOn){
                    if(board[b][a]=='\u3000'){
                        further=false;
                        goOn=false;
                    }
                    if(goOn)
                        b++;
                }
                if(!further&&!goOn)
                    iPlay(b,a);
            }
            a++;
        }
        a=1;
        b=1;
        count=0;
        while (a<4&&b<4&&goOn){
            if(board[a][b]==f)
                count++;
            else if(board[a][b]!='\u3000')
                count=0;
            if (count==2)
                break;
            else{
                a++;
                b++;
            }
        }
        if(count==2){
            a=1;
            b=1;
            while (b<4&&a<4&&goOn){
                if(board[a][b]=='\u3000'){
                    further=false;
                    goOn=false;
                }
                b++;
                a++;
            }
            if(!further&&!goOn){
                a--;
                b--;
                iPlay(a,b);
            }
        }
        a=1;
        b=3;
        count=0;
        while (a<4&&b>0&&goOn){
            if(board[a][b]==f)
                count++;
            else if(board[a][b]!='\u3000')
                count=0;
            if (count==2)
                break;
            else{
                a++;
                b--;
            }
        }
        if(count==2){
            a=1;
            b=3;
            while (b>0&&a<4&&goOn){
                if(board[a][b]=='\u3000'){
                    further=false;
                    goOn=false;
                }
                b--;
                a++;
            }
            if(!further&&!goOn){
                b++;
                a--;
                iPlay(a,b);
            }
        }
    }
    //     public static void fyoochur(){
    //         a=0;
    //         b=0;
    //         
    //     }
    public static void random()throws Exception{
        a=0;
        b=0;
        while (a<1||a>3)
            a=(int)(Math.random()*10);
        while (b<1||b>3)
            b=(int)(Math.random()*10);
        random2();
    }

    public static void random2()throws Exception{
        if(board[a][b]=='\u3000')
            iPlay(a,b);
        else
            random();
    }
    //     public static void win(char f){
    //         print();
    //         if(f==opp)
    //             System.out.println("\nYou Win!!");
    //         else 
    //             System.out.println("\nYou Lose!!");
    //         play=false;
    //     }
    public static boolean whoWin(char f){
        boolean goOn=true;
        a=1;
        b=1;
        count=0;
        while (a<4&&goOn){
            b=1;
            count=0;
            while (b<4){
                if(board[a][b]==f)
                    count++;
                else if(board[a][b]!='\u3000')
                    count=0;
                b++;
            }
            if(count==3){
                goOn=false;
                further=false;
                return true;
            }
            a++;
        }
        a=1;
        b=1;
        count=0;
        while (a<4&&goOn){
            b=1;
            count=0;
            while (b<4){
                if(board[b][a]==f)
                    count++;
                else if(board[b][a]!='\u3000')
                    count=0;
                b++;
            }
            if(count==3){
                goOn=false;
                further=false;
                return true;
            }
            a++;
        }
        a=1;
        b=1;
        count=0;
        while (a<4&&b<4&&goOn){
            if(board[a][b]==f)
                count++;
            else if(board[a][b]!='\u3000')
                count=0;
            a++;
            b++;
        }
        if(count==3){
            goOn=false;
            further=false;
            return true;
        }
        a=1;
        b=3;
        count=0;
        while (a<4&&b>0&&goOn){
            if(board[a][b]==f)
                count++;
            else if(board[a][b]!='\u3000')
                count=0;
            a++;
            b--;
        }
        if(count==3){
            goOn=false;
            further=false;
            return true;
        }
        return false;
    }  

    public static void firstMove()throws Exception{
        if(board[2][2]=='\u3000'){
            iPlay(2, 2);
            further=false;
        }
        else if(board[1][3]=='\u3000'){
            iPlay(1, 3);
            further=false;
        }
        else if(board[1][1]=='\u3000'){
            iPlay(1, 1);
            further=false;
        }
        else if(board[3][3]=='\u3000'){
            iPlay(3, 3);
            further=false;
        }
        else if(board[3][1]=='\u3000'){
            iPlay(3,1);
            further=false;
        }
    }

    public static void main(String []args)throws Exception{
        if(countTwo>0){
            if(one&&two){
                one=true;
            }
            else if(!one&&!two&&countTwo%2!=0)
                two=true;
        }
        System.out.println("To play, enter column letter followed by row number, without spaces.");
        fill();
        youPlay();
    }
}
