import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        while(n-->0) {
            String str = sc.next();
            String[] arr = str.split(",");
            answer = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            System.out.println(answer);
        }
    }
}