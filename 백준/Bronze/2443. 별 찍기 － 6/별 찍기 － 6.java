import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<n-i-1;j++) {
                System.out.print(" ");
            }
            for(int j=i*2;j>=0;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}