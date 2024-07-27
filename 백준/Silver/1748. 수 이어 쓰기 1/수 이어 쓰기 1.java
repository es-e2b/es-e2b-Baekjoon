import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solve(Integer.parseInt(s), s.length()));
    }
    public static int solve(int num, int length) {
        if (length == 1) {
            return num;
        }
        int ans = 0;
        String flag = "";
        int prev = 0;
        for (int i = 1; i < length; i++) {
            flag += "9";
            int tmp = Integer.parseInt(flag);
            ans += (tmp - prev) * i;
            prev = tmp;
        }
        int tmp = Integer.parseInt(flag) + 1;
        ans += (num - tmp + 1) * length;
        return ans;
    }
}