import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int jimin = sc.nextInt();
        int hansu = sc.nextInt();
        int round = 1;
        while(true){
            if(N==1){
                System.out.println(round);
                return;
            }
            if(jimin-1==hansu || hansu-1==jimin) {
                int small = jimin > hansu ? hansu : jimin;
                if (small%2==1){
                    System.out.println(round);
                    return;
                }
            }
            N /= 2;
            if(jimin==1)
                jimin = 1;
            else if(jimin%2==1)
                jimin = jimin/2+1;
            else
                jimin = jimin/2;
            if(hansu == 1)
                hansu = 1;
            else if(hansu%2==1)
                hansu = hansu/2+1;
            else
                hansu = hansu/2;
            round++;
        }
    }
}