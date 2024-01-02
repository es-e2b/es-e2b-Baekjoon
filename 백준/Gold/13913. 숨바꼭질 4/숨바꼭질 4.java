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
    	ArrayDeque<Node> q=new ArrayDeque<>();
    	if(N==M)
    		sb.append(0+"\n"+N);
    	else if(N > M) {
    		sb.append(N-M+"\n");
    		for(int i=N;i>=M;i--)
    			sb.append(i+" ");
    	}
    	else {
    	q.add(new Node(N,0, String.valueOf(N)));
    	int[] time=new int[200000];
    	Arrays.fill(time, Integer.MAX_VALUE);
    	time[N]=0;
    	while(!q.isEmpty()) {
    		Node node=q.poll();
    		int idx=node.idx;
    		int sec=node.time;
    		String s=node.s;
    		if(idx==M&&sec<=time[M]) {
    			sb.append(sec+"\n").append(s);
    			break;
    		}
    		int[] n=new int[3];
    		n[0]=idx*2;
    		n[1]=idx+1;
    		n[2]=idx-1;
    		for(int i=0;i<3;i++) {
    			if(n[i]<0||n[i]>=200000||sec>=time[M]||time[n[i]]<=sec)continue;
    			q.add(new Node(n[i], sec+1,s+" "+String.valueOf(n[i])));
    			time[n[i]]=sec+1;
    		}
    	}
    	}
        bw.append(sb);
        bw.flush();
        bw.close();
    }
    static class Node{
    	int idx;
    	int time;
    	String s;
    	public Node(int idx, int time, String s) {
    		this.idx=idx;
    		this.time=time;
    		this.s=s;
    	}
    }
}