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
//	static int[] dx=new int[] {1,-1,0,0};
//	static int[] dy=new int[] {0,0,1,-1};
	static StringBuilder ssb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	Scanner sc = new Scanner(System.in);
//    	StringTokenizer st=new StringTokenizer(br.readLine());
//    	int n = Integer.parseInt(st.nextToken());
//    	int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) {
					al.get(i).add(j);
				}
			}
		}
		int[][] route = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(route[i], 0);
		for(int i=0;i<N;i++) {
			Stack<ArrayList<Integer>> stack = new Stack<>();
			boolean[] visited = new boolean[N];
			stack.push(al.get(i));
			while(!stack.isEmpty()) {
				ArrayList<Integer> now = stack.pop();
				for(int j=0;j<now.size();j++) {
					if(!visited[now.get(j)]) {
						stack.push(al.get(now.get(j)));
						visited[now.get(j)]=true;
					}
				}
			}
			for(int j=0;j<N;j++) {
				if(visited[j]) {
					route[i][j]=1;
					ssb.append(1).append(' ');
				}
				else
					ssb.append(0).append(' ');
			}
			ssb.append('\n');
		}
		
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}