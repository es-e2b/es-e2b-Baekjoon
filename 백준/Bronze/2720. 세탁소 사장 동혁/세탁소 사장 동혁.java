import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tCase = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};
        int[] cases = new int[4];

        for (int i=0; i<tCase; i++) {
            int money = Integer.parseInt(br.readLine());

            cases[0] = money / coins[0];
            cases[1] = (money % coins[0]) / coins[1];
            cases[2] = ((money % coins[0]) % coins[1]) / coins[2];
            cases[3] = ((money % coins[0]) % coins[1]) % coins[2] / coins[3];

            for (int j=0; j<4; j++) {
                System.out.print(cases[j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}