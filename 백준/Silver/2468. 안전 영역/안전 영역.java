import java.io.*;
import java.util.*;
	
public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
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
		N=read();
		int max=0;
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=read();
				max=Math.max(arr[i][j], max);
			}
		}
		int safe=0;
		for(int i=0;i<max;i++)
			safe=Math.max(sink(i),safe);
		sb.append(safe);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static int sink(int h) {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		int count=0;
		visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]<=h||visited[i][j])continue;
				count++;
				q.add(new int[] {i,j});
				visited[i][j]=true;
				while(!q.isEmpty()) {
					int[] now=q.poll();
					int y=now[0];
					int x=now[1];
					for(int k=0;k<4;k++) {
						int ny=y+dy[k];
						int nx=x+dx[k];
						if(ny<0||ny>=N||nx<0||nx>=N||visited[ny][nx]||arr[ny][nx]<=h)continue;
						q.add(new int[] {ny,nx});
						visited[ny][nx]=true;
					}
				}
			}
		}
		return count;
	}
}