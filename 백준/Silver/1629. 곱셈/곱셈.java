import java.io.*;
import java.util.*;
	
public class Main {
    static long d(long n, long m, long l) {
        if (m == 0) {
            return 1;
        } else if (m % 2 == 0) {
            long temp = d(n, m/2, l) % l;
            return (temp * temp) % l;
        } else {
            return (n*d(n, m-1, l)) % l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        long result = d(n, m, l);
        System.out.println(result);
    }
}