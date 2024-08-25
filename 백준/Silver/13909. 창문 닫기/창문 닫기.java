import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 1; i * i <= N; i++) {
            count++;
        }
        bw.write(count + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}