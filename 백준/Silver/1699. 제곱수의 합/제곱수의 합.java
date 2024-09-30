import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        int dp[] = new int[input + 1];

        for (int i = 1; i <= input; i++) {
            dp[i] = i; 
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(j, 2)] + 1);
            }
        }

        bw.write(dp[input] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}