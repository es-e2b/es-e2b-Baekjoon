import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
	static int N,M;
	static int[][] cost;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	N=read(); M=read();
    	cost=new int[N+1][N+1];
    	for(int i=1;i<=N;i++) {
    		Arrays.fill(cost[i], INF);
    		cost[i][i]=0;
    	}
    	for(int i=0;i<M;i++) {
    		int start=read();
    		int end=read();
    		int weight=read();
    		cost[start][end]=Math.min(weight,cost[start][end]);
    	}
    	for(int k=1;k<=N;k++) {
    		for(int i=1;i<=N;i++)
    			for(int j=1;j<=N;j++) {
    				cost[i][j]=Math.min(cost[i][k]+cost[k][j],cost[i][j]);
    			}
    	}
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			if(cost[i][j]>=INF)
    				cost[i][j]=0;
    			sb.append(cost[i][j]+" ");
    		}
    		sb.append("\n");
    	}
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}