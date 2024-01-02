import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
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
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {N,0});
    	int min=Integer.MAX_VALUE;
    	int[] time=new int[200000];
    	time[N]=0;
    	Arrays.fill(time, Integer.MAX_VALUE);
    	int count=0;
    	while(!q.isEmpty()) {
    		int[] now=q.poll();
    		if(now[0]==M&&now[1]<=time[M]) {
    			min=now[1];
    			count++;
    			continue;
    		}
    		int[] n=new int[3];
    		n[0]=now[0]*2;
    		n[1]=now[0]+1;
    		n[2]=now[0]-1;
    		for(int i=0;i<3;i++) {
    			if(n[i]<0||n[i]>=200000||now[1]>=time[M]||time[n[i]]<=now[1])continue;
    			q.add(new int[] {n[i], now[1]+1});
    			time[n[i]]=now[1]+1;
    		}
    	}
    	sb.append(min+"\n"+count);
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}