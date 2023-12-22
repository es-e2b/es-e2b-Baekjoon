import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
public class Main {
	static int Y;
	static int X;
	static ArrayDeque<int[]> q;
	static int[][] arr; 
	static boolean[][] visited;
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
		Y=read();
		X=read();
		arr=new int[Y+1][X+1];
		visited=new boolean[Y+1][X+1];
		for(int i=1;i<=Y;i++) {
			for(int j=1;j<=X;j++)
				arr[i][j]=read();
		}
		q=new ArrayDeque<>();
		int year=0;
		while(true) {
			int count = check();
			if(count>1) {
				sb.append(year);
				break;
			}
			else if(count==0) {
				sb.append(0);
				break;
			}
			else {
				year();
				year++;
			}
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static int check() {
		visited=new boolean[Y+1][X+1];
		int count=0;
		for(int i=1;i<=Y;i++)
			for(int j=1;j<=X;j++)
				if(arr[i][j]!=0&&!visited[i][j]) {
					q.add(new int[] {i,j});
					visited[i][j]=true;
					count++;
					if(count>1)
						break;
					while(!q.isEmpty()) {
						int[] now=q.poll();
						int y=now[0];
						int x=now[1];
						for(int k=0;k<4;k++) {
							int ny=y+dy[k];
							int nx=x+dx[k];
							if(ny<=0||ny>Y||nx<=0||nx>X||visited[ny][nx]||arr[ny][nx]==0)continue;
							q.add(new int[] {ny,nx});
							visited[ny][nx]=true;
						}
					}
				}
		return count;
	}
	static void year() {
		int[][] temp=new int[Y+1][X+1];
		for(int i=1;i<=Y;i++)
			for(int j=1;j<=X;j++)
				if(arr[i][j]==0)
					temp[i][j]=0;
				else {
					int tmp=arr[i][j];
					for(int k=0;k<4;k++) {
						int ny=i+dy[k];
						int nx=j+dx[k];
						if(ny<=0||ny>Y||nx<=0||nx>X||arr[ny][nx]>0)continue;
						tmp--;
					}
					temp[i][j]=Math.max(tmp, 0);
				}
		arr=temp;
	}
}