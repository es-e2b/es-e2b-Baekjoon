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
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=s.charAt(j)-48;
			}
		}
		int danji=0;
		int numHouse=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int yi=0;yi<N;yi++) {
			for(int xi=0;xi<N;xi++) {
				ArrayDeque<int[]> q = new ArrayDeque<>();
				if(map[yi][xi]==1 && !visited[yi][xi]) {
					q.offer(new int[]{yi,xi});
					visited[yi][xi]=true;
					danji++;
					numHouse++;
				}
				while(!q.isEmpty()){
					int[] temp=q.poll();
					int y=temp[0];
					int x=temp[1];
					for(int i=0;i<4;i++) {
						int nx=x+dx[i];
						int ny=y+dy[i];
						if(nx<0 || nx>=N || ny<0 || ny>=N || visited[ny][nx] || map[ny][nx] == 0)continue;
						q.add(new int[] {ny,nx});
						visited[ny][nx]=true;
						numHouse++;
					}
				}
				if(numHouse!=0) {
					pq.offer(numHouse);
					numHouse=0;
				}
			}
		}
		ssb.append(danji).append('\n');
		while(!pq.isEmpty())
			ssb.append(pq.poll()).append('\n');
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}