import java.io.*;
import java.util.*;
public class Main {
	static int N, K;
	static int[][] W;
	static int[][] V;
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringBuilder sb=new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		N=read();
		K=read();
		W=new int[N][2];
		V=new int[N][K+1];
		for(int i=0;i<N;i++) {
			W[i][0]=read();
			W[i][1]=read();
		}
		for(int i=W[0][0];i<=K;i++) {
			V[0][i]=W[0][1];
		}
		for(int i=1;i<N;i++) {
			V[i]=V[i-1].clone();
			for(int j=K;j>=W[i][0];j--) {
				V[i][j]=Math.max(V[i][j], W[i][1]+V[i][j-W[i][0]]);
			}
		}
		sb.append(V[N-1][K]);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}