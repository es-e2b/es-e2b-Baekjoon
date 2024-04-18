import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        if(t%10!=0)
            System.out.println(-1);
        else
            System.out.println(t/300+" "+(t%300)/60+" "+(t%60)/10);
    }
}