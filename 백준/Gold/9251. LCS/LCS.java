import java.io.*;
import java.util.*;
public class Main {
	static int[][] dp;
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringBuilder sb=new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		String s1=br.readLine(), s2=br.readLine();
		int l1=s1.length(), l2=s2.length();
		dp=new int[l1][l2];
		for(int i=0;i<l1;i++) {
			for(int j=0;j<l2;j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					if(i>0&&j>0)
						dp[i][j]=dp[i-1][j-1]+1;
					else
						dp[i][j]=1;
				}
				else {
					if(i>0&&j>0)
						dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
					else if(i>0)
						dp[i][j]=dp[i-1][j];
					else if(j>0)
						dp[i][j]=dp[i][j-1];
					else
						dp[i][j]=0;
				}
			}
		}
		sb.append(dp[l1-1][l2-1]);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}