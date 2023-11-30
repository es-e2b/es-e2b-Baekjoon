import java.io.*;
import java.util.*;
	
public class Main {
	private static int read() throws Exception
    {
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		int T=read();
		while(T-->0) {
			int col=read();
			int[][] arr=new int[2][col+1];
			for(int i=0;i<2;i++)
				for(int j=1;j<=col;j++)
					arr[i][j]=read();
			int[][] sum=new int[2][col+1];
			sum[0][1]=arr[0][1];
			sum[1][1]=arr[1][1];
			for(int i=2;i<=col;i++) {
				sum[0][i]=Math.max(sum[1][i-1], sum[1][i-2])+arr[0][i];
				sum[1][i]=Math.max(sum[0][i-1], sum[0][i-2])+arr[1][i];
			}
				
			sb.append(Math.max(sum[1][col], sum[0][col])).append('\n');
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}