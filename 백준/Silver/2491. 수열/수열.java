import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int max = 0, min = 0, answer = 0, maxCnt = 0, minCnt = 0;
        for (int now : arr) {
            if (now >= max) maxCnt++;
            else maxCnt = 1;
            if (now <= min) minCnt++;
            else minCnt = 1;
            answer = Math.max(answer, Math.max(maxCnt, minCnt));
            max = now;
            min = now;
        }
        System.out.println(Math.max(answer, Math.max(maxCnt, minCnt)));
    }
}