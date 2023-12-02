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
		int k=read();//부술 수 있는 횟수
		int[][] arr=new int[row+1][col+1];
		int[][] destroy=new int[row+1][col+1];//부술 수 있는 횟수가 몇 번인 상태로 방문했는지
		for(int i=1;i<=row;i++) {
			String s=br.readLine();
			for(int j=1;j<=col;j++) {
				arr[i][j]=s.charAt(j-1)-'0';
			}
		}
		ArrayDeque<Node> q=new ArrayDeque<>();
		q.add(new Node(1,1,k+1,1, false));
		while(!q.isEmpty()) {
			Node now=q.poll();
//			System.out.println(now.Y+" "+now.X+" "+now.count+" "+now.state);
			int x=now.X;
			int y=now.Y;
			if(y==row&&x==col) {
//				System.out.println("check");
				sb.append(now.count);
				break;
			}
            else if (destroy[y][x] > now.destroy)//벽이라 뚫고 온 시점에서는 방문 전 시점과 달라서 한번 더 검사
                continue;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<=0 || nx>col || ny<=0 || ny>row)continue;
				//지금 내 남은 기회보다 해당 타일을 방문할 시점에 남아있던 기회가 더 큰 경우
				if(destroy[ny][nx]>=now.destroy)continue; 
				//부술 수 있는 기회가 없는데 벽인 경우
				if(arr[ny][nx]==1) {
					if(now.destroy==1)continue;//기회를 다 쓴 경우
					if(now.state) {
						q.add(new Node(ny,nx,now.destroy-1,now.count+1, now.state));
						destroy[ny][nx]=now.destroy-1;
					}
					else {
						q.add(new Node(y,x,now.destroy,now.count+1,now.state));
					}
				}
				else {
					q.add(new Node(ny,nx,now.destroy,now.count+1, now.state));
					destroy[ny][nx]=now.destroy;
				}
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
		int destroy;
		int count;
		boolean state;
		Node(int y,int x,int destroy, int c, boolean state){
			X=x;
			Y=y;
			this.destroy=destroy;
			count=c;
			this.state=!state;
		}
	}
}