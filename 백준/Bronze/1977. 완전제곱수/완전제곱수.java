import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int min = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = m; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i == j * j) {
                    sum += i; 
                    cnt++;
                    if (cnt == 1) {
                        min = i;
                    }
                }
            }
        }

        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println("-1");
        }

    }
}