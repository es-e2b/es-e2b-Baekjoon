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
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		boolean[][] visited1 = new boolean[n][n];
		boolean[][] visited2 = new boolean[n][n];
		Queue<int[]> q = new ArrayDeque<>();
		int count = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				if(!visited1[i][j]) {
					q.offer(new int[] {i,j});
					visited1[i][j]=true;
					count++;
					while(!q.isEmpty()) {
						int[] now = q.poll();
						int y=now[0];
						int x=now[1];
						char c = map[y][x];
						for(int k=0;k<4;k++) {
							int nx=x+dx[k];
							int ny=y+dy[k];
							if(nx<0 || nx>=n || ny<0 || ny>=n || visited1[ny][nx] || map[ny][nx] != c)continue;
							q.add(new int[] {ny,nx});
							visited1[ny][nx]=true;
						}
						
						
					}
				}
			}
		ssb.append(count).append(' ');
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(map[i][j]=='G')
					map[i][j]='R';
		count = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				if(!visited2[i][j]) {
					q.offer(new int[] {i,j});
					visited2[i][j]=true;
					count++;
					while(!q.isEmpty()) {
						int[] now = q.poll();
						int y=now[0];
						int x=now[1];
						char c = map[y][x];
						for(int k=0;k<4;k++) {
							int nx=x+dx[k];
							int ny=y+dy[k];
							if(nx<0 || nx>=n || ny<0 || ny>=n || visited2[ny][nx] || map[ny][nx] != c)continue;
							q.add(new int[] {ny,nx});
							visited2[ny][nx]=true;
						}
						
						
					}
				}
			}
		ssb.append(count).append(' ');
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}