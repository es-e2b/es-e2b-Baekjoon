import java.io.*;
import java.util.*;

public class Main {
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
    	for(int i=0;i<=N;i++) {
    		Arrays.fill(cost[i], -1);
    		cost[i][i]=0;
    	}
    	for(int i=0;i<M;i++) {
    		int start=read();
    		int end=read();
    		int weight=read();
    		if(cost[start][end]>0)
    			cost[start][end]=Math.min(weight,cost[start][end]);
    		else
    			cost[start][end]=weight;
    	}
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	for(int i=1;i<=N;i++) {
    		q.add(new int[] {i,0});
    		while(!q.isEmpty()) {
    			int[] now=q.poll();
//    			System.out.println("\n now : "+now[0]+" "+now[1]);
    			if(cost[i][now[0]]==-1||now[1]<cost[i][now[0]])
    				cost[i][now[0]]=now[1];
    			for(int k=1;k<=N;k++) {
    				int newCost=now[1]+cost[now[0]][k];
//    				if(cost[now[0]][k]>0)
//    					System.out.println("new : "+k+" "+newCost);
    				if(now[0]==k||k==i||cost[now[0]][k]<=0||cost[i][k]>0&&cost[i][k]<newCost)continue;
//    				System.out.println("add : "+k+" "+newCost);
    				q.offer(new int[] {k,newCost});
    			}
    		}
    	}
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			if(cost[i][j]==-1)
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