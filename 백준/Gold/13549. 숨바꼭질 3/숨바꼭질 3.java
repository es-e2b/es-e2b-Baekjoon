import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
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
		int start=read();
		int end=read();
		int max=end*2;
		ArrayDeque<Integer> q=new ArrayDeque<>();
		q.add(start);
		int[] p=new int[200002];
		Arrays.fill(p, -1);
		p[start]=0;
		while(!q.isEmpty()) {
			int now=q.poll();
			if(now==end) {
				sb.append(p[now]);
				break;
			}
			int minus=now-1;
			int plus=now+1;
			int multi=now<<1;
			if(multi<=max&&multi>0)
			if(p[multi]==-1||p[multi]>p[now]) {
				q.push(multi);
				p[multi]=p[now];
			}
			if(minus>=0)
			if(p[minus]==-1||p[minus]>p[now]+1) {
				q.add(minus);
				p[minus]=p[now]+1;
			}
			if(plus<=max)
			if(p[plus]==-1||p[plus]>p[now]+1) {
				q.add(plus);
				p[plus]=p[now]+1;
			}
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}