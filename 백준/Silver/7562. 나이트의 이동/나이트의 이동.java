import java.io.*;
import java.util.*;
	
public class Main {
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
		int[] dx=new int[] {1, 2, 2, 1, -1, -2, -2, -1};
		int[] dy=new int[] {2, 1, -1,-2,-2, -1, 1, 2};
		while(T-->0) {
			int N=read();
			int[][] arr=new int[N][N];
			ArrayDeque<int[]> q=new ArrayDeque<>();
			int[] target=new int[] {read(), read()};
			int[] start =new int[] {read(),read()};
			q.add(start);
			arr[start[0]][start[1]]=1;
			while(!q.isEmpty()) {
				int[] now=q.poll();
				if(now[0]==target[0]&&now[1]==target[1]) {
					sb.append(arr[target[0]][target[1]]-1+"\n");
					break;
				}
				int y=now[0];
				int x=now[1];
				for(int k=0;k<8;k++) {
					int ny=y+dy[k];
					int nx=x+dx[k];
					if(ny<0||ny>=N||nx<0||nx>=N||arr[ny][nx]!=0)continue;
					q.add(new int[] {ny,nx});
					arr[ny][nx]=arr[y][x]+1;
				}
			}
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}