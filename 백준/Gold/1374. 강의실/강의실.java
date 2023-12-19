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
		int T=read();
		PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0]-o2[0];
		}});
		while(T-->0) {
			read();
			q.add(new int[] {read(), read()});
		}
		PriorityQueue<Integer> rooms=new PriorityQueue<>();
		rooms.add(q.poll()[1]);
		while(!q.isEmpty()) {
			int[] now=q.poll();
			if(rooms.peek()<=now[0])
				rooms.poll();
			rooms.add(now[1]);
		}
		sb.append(rooms.size());
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}