import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	int n=read();
    	int[] dp=new int[n+1];
    	dp[0]=0;
    	dp[1]=1;
    	for(int i=2;i<=n;i++) {
    		dp[i]=dp[i-1]+dp[i-2];
    	}
    	sb.append(dp[n]);
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}