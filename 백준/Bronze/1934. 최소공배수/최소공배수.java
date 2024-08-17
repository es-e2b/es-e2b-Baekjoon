import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 0; i < T; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int result =  (B * A) / calcGcd(B , A);
            System.out.println(result);
        }
    }
    public static int calcGcd(int big, int small) {
        if (big % small == 0) {
            return small;
        }
        return calcGcd(small, big % small);
    }
}