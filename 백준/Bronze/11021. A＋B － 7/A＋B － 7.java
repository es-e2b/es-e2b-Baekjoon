import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
    	int T=read();
    	for(int i=1;i<=T;i++) {
    		sb.append("Case #").append(i).append(": ").append(read()+read()+"\n");
    	}
        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }
}