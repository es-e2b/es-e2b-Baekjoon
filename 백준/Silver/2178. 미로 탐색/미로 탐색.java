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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-48;
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{0,0});
		visited[0][0]=true;
		while(!q.isEmpty()){
			int[] temp=q.poll();
			int y=temp[0];
			int x=temp[1];
			if(x==M-1&&y==N-1) {
				ssb.append(map[y][x]);
				break;
			}
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0 || nx>=M || ny<0 || ny>=N || visited[ny][nx] || map[ny][nx] == 0)continue;
				q.add(new int[] {ny,nx});
//				System.out.print(ny+" "+nx+" ");
//				System.out.println(map[ny][nx]);
				map[ny][nx]=map[y][x]+1;
				visited[ny][nx]=true;
			}
		}
		
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}
