import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, t;
        for (int i = 0; i < 4; i++){
            t = sc.nextInt();
            a += t;
        }
        for (int i = 0; i < 4; i++){
            t = sc.nextInt();
            b += t;
        }
        System.out.println(Math.max(a, b));
    }
}