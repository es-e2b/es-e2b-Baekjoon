import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
	static StringBuilder ssb=new StringBuilder();
	static int[][] paper;
	static class Node{
		int x;
		int y;
		int count=1; //몇번째 블럭인지
		int sum; //값의 합
		Node parent=null; //누가 부모인지
		Node(int y, int x, int sum){
			this.y =y;
			this.x = x;
			this.sum=sum;
		}
		Node(int y,int x, Node parent, int sum){
			this.y =y;
			this.x = x;
			this.parent=parent;
			this.sum=parent.sum+sum;
			this.count=parent.count+1;
		}
		int DFS(){
			ArrayDeque<Node> q = new ArrayDeque<>();
			q.push(this);
			int max=0;
			while(!q.isEmpty()){ // T자가 아닌 테트리미노 DFS
				Node now = q.poll();
//				if(now.x==paper[0].length-1&&now.count==4)
//					System.out.println(now.sum+" "+now.parent.sum+" "+now.parent.parent.sum+" "+now.parent.parent.parent.sum);
				if(now.count>3) {
					max=Math.max(max, now.sum);
					continue;
				}
				int Y=now.y;
				int X=now.x;
				for(int k=0;k<4;k++) {
					int nx=X+dx[k];
					int ny=Y+dy[k];
					if(now.parent!=null && now.parent.y==ny && now.parent.x==nx)continue;
					if(nx<0 || nx>=paper[0].length || ny<0 || ny>=paper.length)continue;
					q.push(new Node(ny, nx, now, paper[ny][nx]));
				}
			}
			q.push(this);
			while(!q.isEmpty()) {
				Node now = q.poll();
				int Y=now.y;
				int X=now.x;
				if(now.parent==null) {
					for(int k=0;k<4;k++) {
						int nx=X+dx[k];
						int ny=Y+dy[k];
						if(nx<0 || nx>=paper[0].length || ny<0 || ny>=paper.length)continue;
						q.push(new Node(ny, nx, now, paper[ny][nx]));
					}
					continue;
				}
				int temp=0;
				for(int k=0;k<4;k++) {
					int nx=X+dx[k%4];
					int ny=Y+dy[k%4];
					int nx2=X+dx[(k+1)%4];
					int ny2=Y+dy[(k+1)%4];
					if(now.parent.y==ny && now.parent.x==nx)continue;
					if(now.parent.y==ny2 && now.parent.x==nx2)continue;
					if(nx<0 || nx>=paper[0].length || ny<0 || ny>=paper.length)continue;
					if(nx2<0 || nx2>=paper[0].length || ny2<0 || ny2>=paper.length)continue;
					max=Math.max(max, now.sum+paper[ny][nx]+paper[ny2][nx2]);
				}
			}
			
			return max;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		paper = new int[y][x];
		int max = 0;
		for(int i=0;i<y;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				max=Math.max(max, new Node(i,j,paper[i][j]).DFS());
			}
		}
		ssb.append(max);
		
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}