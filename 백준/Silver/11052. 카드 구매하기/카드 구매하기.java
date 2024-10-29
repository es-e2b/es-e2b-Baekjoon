import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = sc.nextInt();
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}