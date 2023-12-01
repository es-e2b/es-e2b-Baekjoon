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
	public static void main(String[] args) throws Exception {
		int row=read();
		int col=read();
		int[][] arr=new int[row+1][col+1];
		int[][] count=new int[row+1][col+1];
		for(int i=1;i<=row;i++) {
			String s=br.readLine();
			for(int j=1;j<=col;j++) {
				arr[i][j]=s.charAt(j-1)-'0';
			}
		}
		boolean[][] visited=new boolean[row+1][col+1];
		boolean[][] notDestroyed=new boolean[row+1][col+1];
		ArrayDeque<Node> q=new ArrayDeque<>();
		visited[1][1]=true;
		q.add(new Node(1,1,false,1));
		while(!q.isEmpty()) {
			Node now=q.poll();
//			System.out.println(now.Y+" "+now.X);
			int x=now.X;
			int y=now.Y;
			if(y==row&&x==col) {
//				System.out.println("check");
				sb.append(now.count);
				break;
			}
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<=0 || nx>col || ny<=0 || ny>row)continue;
				if(arr[ny][nx]==1) { // 벽인 경우
					if(visited[ny][nx])continue; //벽인데도 방문했을 경우 다음
					if(now.detroy)continue; //이미 부수고 온 경우 다음
					//부수면서 통과
					q.add(new Node(nx,ny,true,now.count+1));
//					System.out.println("new:"+ny+" "+nx);
					visited[ny][nx]=true;
					continue;
				}
				//아래는 벽이 아닌 경우
				//벽은 아닌데 이미 방문했고, 파괴하지 않고도 방문했을 경우
				if(notDestroyed[ny][nx])continue;
				//벽은 아닌데 이미 방문했고, 파괴하고 지나갔는데, 이미 난 파괴하고 왔을때
				if(!notDestroyed[ny][nx]&&visited[ny][nx]&&now.detroy)continue;
				
				//아래는 방문하지 않은 경우
//				System.out.println("new:"+ny+" "+nx);
				q.add(new Node(nx,ny,now.detroy,now.count+1));
				visited[ny][nx]=true;
				//만약 내가 부수지 않고 왔으면 추가적으로 방문2도 찍음
				if(!now.detroy)
					notDestroyed[ny][nx]=true;
			}
		}
		if(sb.length()==0)
			sb.append(-1);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static class Node{
		int X;
		int Y;
		boolean detroy;
		int count;
		Node(int x,int y,boolean destroy, int c){
			X=x;
			Y=y;
			this.detroy=destroy;
			count=c;
		}
	}
}