import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        final int ARR_SIZE = 63300;
        int[] primeNum = new int[ARR_SIZE];

        int T;
        long n;
        boolean isPrime = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < ARR_SIZE; i++) {
            primeNum[i] = 1;
        }
        primeNum[0] = 0;
        primeNum[1] = 0;

        for (int i = 2; i < ARR_SIZE; i++) {
            for (int j = 2; i * j < ARR_SIZE; j++) {
                primeNum[i * j] = 0;
            }
        }
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Long.parseLong(br.readLine());
            if (n <= 1) {
                System.out.println(2);
            } else {
                for (long i = n;; i++) {
                    int m = (int) Math.sqrt(i);
                    isPrime = true;
                    for (int j = 1; j <= m; j++) {
                        if (primeNum[j] == 1) {
                            if (i % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    if (isPrime) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}