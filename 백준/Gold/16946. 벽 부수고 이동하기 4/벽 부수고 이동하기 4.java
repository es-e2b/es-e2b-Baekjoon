import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
public class Main {
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
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
	
	static int[][] arr;
	static int[][] ans;
	static int[][] marking;
	static ArrayList<Integer> al;
	static int mark=1;
	static int row;
	static int col;
	
	public static void main(String[] args) throws Exception {
		row=read();
		col=read();
		arr=new int[row+1][col+1];
		ans=new int[row+1][col+1];
		marking=new int[row+1][col+1];
		al=new ArrayList<>();
		al.add(0);
		for(int i=1;i<=row;i++) {
			String s=br.readLine();
			for(int j=1;j<=col;j++) {
				arr[i][j]=s.charAt(j-1)-'0';
			}
		}
		ArrayDeque<int[]> q=new ArrayDeque<>();
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				HashSet<Integer> visited=new HashSet<>();
				if(arr[i][j]==0)continue;
				q.add(new int[] {i,j});
				int count=1;
				while(!q.isEmpty()) {
					int[] now=q.poll();
					int y=now[0];
					int x=now[1];
//					System.out.println("now : "+y+", "+x);
					for(int k=0;k<4;k++) {
						int nx=x+dx[k];
						int ny=y+dy[k];
						if(nx<=0 || nx>col || ny<=0 || ny>row||arr[ny][nx]==1||visited.contains(marking[ny][nx]))continue;
						if(marking[ny][nx]==0)
							marking(ny,nx);
//						System.out.println(marking[ny][nx]);
						count+=al.get(marking[ny][nx]);
						visited.add(marking[ny][nx]);
					}
				}
				ans[i][j]=count%10;
//				System.out.println();
			}
			
		}
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				sb.append(ans[i][j]);
			}
			sb.append('\n');
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static void marking(int y1, int x1) {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		q.add(new int[] {y1,x1});
		marking[y1][x1]=mark;
		int count=1;
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int y=now[0];
			int x=now[1];
			for(int k=0;k<4;k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if(nx<=0 || nx>col || ny<=0 || ny>row||arr[ny][nx]==1||marking[ny][nx]>0)continue;
				q.add(new int[] {ny,nx});
				marking[ny][nx]=mark;
				count++;
			}
		}
		al.add(count);
		mark++;
	}
}