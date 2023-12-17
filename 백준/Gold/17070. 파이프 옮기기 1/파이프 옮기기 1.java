import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
public class Main {
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
		int T=read();
		int[][] arr=new int[T+1][T+1];
		for(int i=1;i<=T;i++)
			for(int j=1;j<=T;j++)
				arr[i][j]=read();
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1,1});
		q.offer(new int[] {1,2});
		int count=0;
		while(!q.isEmpty()) {
			int[] tail=q.poll();
			int[] head=q.poll();
			if(head[0]==T&&head[1]==T) {
				count++;
			}
			if(head[0]<T&&head[1]<T)
			if(arr[head[0]+1][head[1]+1]==0&&arr[head[0]+1][head[1]]==0&&arr[head[0]][head[1]+1]==0){
				q.offer(head);
				q.offer(new int[] {head[0]+1,head[1]+1});
			}
			if(head[0]<T&&head[0]<T&&tail[0]<head[0])
			if(arr[head[0]+1][head[1]]==0){//꼬리의 y가 head의 y보다 작은 경우
				q.offer(head);
				q.offer(new int[] {head[0]+1,head[1]});
			}
			if(head[1]<T&&tail[1]<head[1])
			if(arr[head[0]][head[1]+1]==0){//꼬리의 x가 head의 x보다 작은 경우
				q.offer(head);
				q.offer(new int[] {head[0],head[1]+1});
			}
		}
		sb.append(count);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}