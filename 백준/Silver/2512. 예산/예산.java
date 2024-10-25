import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            high = Math.max(high, arr[i]);
        }
        int max = Integer.parseInt(br.readLine());
        if (sum <= max) {
            System.out.println(high);
            return;
        }
        int low = 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (f(mid) > max) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(low);
    }
    static int f(int h) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(arr[i], h);
        }
        return total;
    }
}