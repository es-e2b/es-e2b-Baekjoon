import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        System.out.println(solve(document, word));
    }
    public static int solve(String document, String word) {
        int count = 0;
        int idx = 0;
        int length = document.length();
        for (int i = 0; i < length; i++) {
            if (document.contains(word)) {
                count++;
                idx = document.indexOf(word) + word.length();
                document = document.substring(idx, document.length());
            }
        }
        return count;
    }
}