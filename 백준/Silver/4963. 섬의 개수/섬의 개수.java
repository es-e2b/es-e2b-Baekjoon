import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
public class Main {
	static int[] dx=new int[] {1,-1,0,0,1,-1,1,-1};
	static int[] dy=new int[] {0,0,1,-1,1,-1,-1,1};
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
		while(true) {
			int X=read();
			int Y=read();
			if(X==0 && Y==0)
				break;
			int[][] arr=new int[Y+1][X+1];
			for(int i=1;i<=Y;i++) {
				for(int j=1;j<=X;j++) {
					arr[i][j]=read();
				}
			}
			boolean[][] visited=new boolean[Y+1][X+1];
			ArrayDeque<int[]> q=new ArrayDeque<>();

			int count=0;
			for(int i=1;i<=Y;i++)
				for(int j=1;j<=X;j++) {
					if(arr[i][j]==0||visited[i][j])
						continue;
					q.add(new int[] {i,j});
					visited[i][j]=true;
					boolean flag=false;
					while(!q.isEmpty()) {
						int[] now=q.poll();
						int x=now[1];
						int y=now[0];
						if(arr[y][x]==0)
							continue;
						flag=true;
						for(int k=0;k<8;k++) {
							int nx=x+dx[k];
							int ny=y+dy[k];
							if(ny<1||ny>Y||nx<1||nx>X||visited[ny][nx]||arr[ny][nx]==0)continue;
							q.add(new int[]{ny,nx});
							visited[ny][nx]=true;
						}
					}
					if(flag)
						count++;
				}
			sb.append(count).append('\n');
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}