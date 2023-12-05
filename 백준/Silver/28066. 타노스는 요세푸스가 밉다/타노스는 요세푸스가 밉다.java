import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
public class Main {
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
	private static int read() throws Exception{
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
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int N=read();
		int K=read();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		while(q.size()>1) {
			q.offer(q.poll());
			for(int i=0;i<K-1;i++) {
				if(q.size()==1)break;
				q.poll();
			}
		}
		sb.append(q.peek());
		
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}