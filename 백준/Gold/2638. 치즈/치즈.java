import java.io.*;
import java.util.*;
	
public class Main {
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
	static int[][] arr,melt;
	static int N, M;
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringTokenizer st;
	static StringBuilder sb=new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		N=read(); M=read();
		arr=new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				arr[i][j]=read();
		int count=0;
		for(;!check();count++) {
			ArrayDeque<int[]> q=new ArrayDeque<>();
			melt=new int[N][M];
			boolean[][] visited=new boolean[N][M];
			q.add(new int[] {0,0});
			visited[0][0]=true;
			while(!q.isEmpty()) {
				int[] now=q.poll();
				int y=now[0];
				int x=now[1];
				for(int k=0;k<4;k++) {
					int ny=y+dy[k];
					int nx=x+dx[k];
					if(ny<0||ny>=N||nx<0||nx>=M||visited[ny][nx])continue;
					if(arr[ny][nx]==1) {
						melt[ny][nx]++;
						continue;
					}
					q.add(new int[] {ny,nx});
					visited[ny][nx]=true;
				}
			}
			melt();
		}
		sb.append(count);
		bw.append(sb);
        bw.flush();
        bw.close();
	}
	static boolean check() {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(arr[i][j]==1)
					return false;
		return true;
	}
	static void melt() {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(melt[i][j]>1)
					arr[i][j]=0;
	}
}