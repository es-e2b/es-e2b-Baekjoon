import java.io.*;
public class Main {
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringBuilder sb=new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int N=read();
		int K=read();
		int[] W=new int[N];
		int[] V=new int[N];
		int[] dp=new int[K+1];
		for(int i=0;i<N;i++) {
			W[i]=read();
			V[i]=read();
			for(int j=K;j>=0;j--) {
				if(j+W[i]>K)continue;
				dp[j+W[i]]=Math.max(dp[j+W[i]], dp[j]+V[i]);
			}
		}
		sb.append(dp[K]);
		bw.append(sb);
        bw.flush();
        bw.close();
	}
}