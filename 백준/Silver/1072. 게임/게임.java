import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long X, Y;
    static long Z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;
        if (Z >= 99)
        {
            System.out.println(-1);
            return ;
        }
        int l = 0;
        int r = 1000000000;
        long ans = -1;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            long tmp = 100 * (Y + mid) / (X + mid);
            if (tmp != Z)
            {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        System.out.println(ans);
    }
}