import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        recursion(s);
    }
    public static void recursion(String s) {
        if (s.length() == 1) {
            int num = Integer.parseInt(s);
            System.out.println(count);
            if (num == 3 || num == 6 || num == 9) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            return ;
        }
        long num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += Long.parseLong(Character.toString(s.charAt(i)));
        }
        count++;
        recursion(Long.toString(num));
    }
}