import java.io.*;
import java.util.*;
	
public class Main {
	static int[][] map;
	static int Y, X;
	static boolean[][] visited;
	static int max=0;
	static ArrayList<int[]> virus=new ArrayList<>();
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
		map=new int[Y+1][X+1];
		visited=new boolean[Y+1][X+1];
		for(int i=1;i<=Y;i++) {
			for(int j=1;j<=X;j++) {
				map[i][j]=read();
				if(map[i][j]==2)
					virus.add(new int[] {i,j});
			}
		}
		addWall(0);
		sb.append(max);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	//백트래킹 함수
	static void addWall(int count) {
		if(count==3) {
			max=Math.max(plague(),max);
			return;
		}
		for(int i=1;i<=Y;i++) {
			for(int j=1;j<=X;j++) {
				if(map[i][j]!=0)continue;
				map[i][j]=1;
				addWall(count+1);
				map[i][j]=0;
			}
		}
	}
	static int plague() {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		int[][] preMap=new int[Y+1][X+1];
		for(int i=1;i<=Y;i++) {
			preMap[i]=Arrays.copyOf(map[i], X+1);
		}
		for(int[] tmp : virus) {
			q.add(tmp);
			while(!q.isEmpty()) {
				int[] now=q.poll();
				int y=now[0];
				int x=now[1];
				for(int k=0;k<4;k++) {
					int ny=y+dy[k];
					int nx=x+dx[k];
					if(ny<1||ny>Y||nx<1||nx>X||map[ny][nx]!=0)continue;
					q.add(new int[] {ny,nx});
					map[ny][nx]=2;
				}
			}
		}
		int safe=0;
		for(int i=1;i<=Y;i++) {
			for(int j=1;j<=X;j++) {
				if(map[i][j]==0)
					safe++;
			}
		}
		map=preMap;
		return safe;
	}
}