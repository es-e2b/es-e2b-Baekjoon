import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        while((input = br.readLine()) != null){
            int[] cnt = new int[4];
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') cnt[0]++;
                else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') cnt[1]++;
                else if(input.charAt(i) >= '0' && input.charAt(i) <= '9') cnt[2]++;
                else if(input.charAt(i) == ' ') cnt[3]++;
            }

            for(int i : cnt)
                sb.append(i).append(" ");

            System.out.println(sb.toString());
        }
    }
}