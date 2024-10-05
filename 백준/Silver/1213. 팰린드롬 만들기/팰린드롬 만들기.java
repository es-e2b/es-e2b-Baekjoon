import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] intArray = new int[26];
        String str = br.readLine();
        boolean ischeck = false;
        boolean isexit = false;
        StringBuilder sb = new StringBuilder();
        int length = str.length();

        for(int i = 0; i < length; i++) {
            intArray[str.charAt(i) - 'A']++;
        }
        char middleChar = 0;
        for(int i = 0; i < 26; i++) {
            if(intArray[i] % 2 == 1) {
                if(length % 2 == 1 && !ischeck) {
                    ischeck = true;
                    middleChar = (char)(i + 'A');
                    intArray[i]--;
                } else {
                    bw.write("I'm Sorry Hansoo");
                    isexit = true;
                    break;
                }
            }
        }

        if(!isexit) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < intArray[i] / 2; j++) {
                    sb.append((char)(i + 'A'));
                }
            }
            String half = sb.toString();
            sb.append(middleChar != 0 ? middleChar : "");
            sb.append(new StringBuilder(half).reverse().toString());

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}