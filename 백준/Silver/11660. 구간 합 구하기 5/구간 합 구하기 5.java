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
		int N=read();
		int t=read();
		int[][] p=new int[N+1][N+1];
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++) {
				p[i][j]=read()+p[i][j-1]+p[i-1][j]-p[i-1][j-1];
			}
		while(t-->0) {
			int x1=read();
			int y1=read();
			int x2=read();
			int y2=read();
			sb.append((p[x2][y2]-p[x1-1][y2]-p[x2][y1-1]+p[x1-1][y1-1])+"\n");
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}