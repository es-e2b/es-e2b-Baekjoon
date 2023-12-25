import java.io.*;
import java.util.*;
	
public class Main {
	static int Y;
	static int X;
	static char[][] alph;
	static int max=0;
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
		alph=new char[Y][X];
		for(int i=0;i<Y;i++) {
			String s=br.readLine();
			for(int j=0;j<X;j++) {
				alph[i][j]=s.charAt(j);
			}
		}
		dfs(new boolean[26], 1, 0, 0);
		sb.append(max);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static void dfs(boolean[] visited,int count, int y, int x) {
		visited[alph[y][x]-'A']=true;
		for(int k=0;k<4;k++) {
			int ny=y+dy[k];
			int nx=x+dx[k];
			if(ny<0||ny>=Y||nx<0||nx>=X||visited[alph[ny][nx]-'A']) {
				max=Math.max(count,max);
				continue;
			}
			dfs(visited.clone(),count+1,ny,nx);
		}
	}
}