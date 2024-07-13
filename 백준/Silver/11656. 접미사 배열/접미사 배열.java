import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputStr = br.readLine();
        String[] arr = new String[inputStr.length()];
        String tmp = inputStr;
        for(int i = 0; i < inputStr.length(); i++) {
            arr[i] = tmp;
            tmp = inputStr.substring(i + 1);
        }
        Collections.sort(Arrays.asList(arr));
        for(int j = 0; j < arr.length; j++) {
            bw.append(arr[j]).append("\n");
        }
        bw.flush();
        bw.close();
    }
}