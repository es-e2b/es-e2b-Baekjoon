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
    	if(N==M)
    		sb.append(0+"\n"+N);
    	else if(N > M) {
    		sb.append(N-M+"\n");
    		for(int i=N;i>=M;i--)
    			sb.append(i+" ");
    	}
    	else {
    		ArrayDeque<Integer> q=new ArrayDeque<>();
	    	q.add(N);
	    	int[] time=new int[200000];
	    	int[] arr=new int[200000];
	    	Arrays.fill(time, Integer.MAX_VALUE);
	    	time[N]=0;
	    	arr[N]=-1;
	    	while(!q.isEmpty()) {
	    		int now=q.poll();
	    		if(now==M) {
	    			break;
	    		}
	    		int[] n=new int[3];
	    		n[0]=now*2;
	    		n[1]=now+1;
	    		n[2]=now-1;
	    		for(int i=0;i<3;i++) {
	    			if(n[i]<0||n[i]>=200000||time[n[i]]<=now)continue;
	    			q.add(n[i]);
	    			time[n[i]]=time[now]+1;
	    			arr[n[i]]=now;
	    		}
	    	}
	    	sb.append(time[M]+"\n");
	    	q.clear();
	    	for(int i=M;i!=-1;i=arr[i]) {
	    		q.push(i);
	    	}
	    	while(!q.isEmpty()) {
	    		sb.append(q.poll()+" ");
	    	}
    	}
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}