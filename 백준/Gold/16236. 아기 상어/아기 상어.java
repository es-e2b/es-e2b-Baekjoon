import java.io.*;
import java.util.*;
	
public class Main {
	static int[] dx=new int[] {0,-1,1,0};
	static int[] dy=new int[] {-1,0,0,1};
	static int N, size=2, ate=0, ans=0;
	static int[] shark;
	static int[][] arr;
	static boolean[][] visited;
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
		N=read();
		arr=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				arr[i][j]=read();
				if(arr[i][j]==9)
					shark=new int[] {i,j,0}; // 상어의 현재 위치를 1로 지정. 나중에 먹이 섭취시 -1해서 이동 시간을 더해줄 것.
			}
		while(search());
		sb.append(ans);
		bw.append(sb);
        bw.flush();
        bw.close();
	}
	static boolean search() {
		visited=new boolean[N][N];
		PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]!=o2[2])
					return o1[2]-o2[2];
				else if(o1[0]!=o2[0])
					return o1[0]-o2[0];
				else
					return o1[1]-o2[1];
			}
			
		}) ;
		q.add(shark);
		visited[shark[0]][shark[1]]=true;
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int y=now[0];
			int x=now[1];
			int count=now[2];
			if(arr[y][x]>0&&arr[y][x]<size) {
				arr[y][x]=0;
				ans+=count;
				eat();
				arr[shark[0]][shark[1]]=0;
				shark=new int[] {y,x,0};
				arr[shark[0]][shark[1]]=Integer.MAX_VALUE;
				return true;
			}
			for(int k=0;k<4;k++) {
				int ny=y+dy[k];
				int nx=x+dx[k];
				if(ny<0||ny>=N||nx<0||nx>=N||arr[ny][nx]>size||visited[ny][nx])continue;
				q.add(new int[] {ny,nx,count+1});
				visited[ny][nx]=true;
			}
		}
		return false;
	}
	static void eat() {
		ate++;
		if(ate<size)
			return;
		size++;
		ate=0;
	}
}