import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String st[] = new String[num];
        for (int i = 0; i < num; i++) {
            st[i] = br.readLine();
        }
        solve(st);
    }

    public static void solve(String[] st) {
        Arrays.sort(st, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                }

                else if (o1.length() < o2.length()) {
                    return -1;
                }
                else {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (!(o1.charAt(i) >= 65 && o1.charAt(i) <= 90)) {
                            sum1 += o1.charAt(i) - '0';
                        }
                    }

                    for (int i = 0; i < o2.length(); i++) {
                        if (!(o2.charAt(i) >= 65 && o2.charAt(i) <= 90)) {
                            sum2 += o2.charAt(i) - '0';
                        }
                    }

                    if (sum1 > sum2) {
                        return 1;
                    }
                    else if (sum1 < sum2) {
                        return -1;
                    }
                    else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });
        for (String s : st) {
            System.out.println(s);
        }
    }
}