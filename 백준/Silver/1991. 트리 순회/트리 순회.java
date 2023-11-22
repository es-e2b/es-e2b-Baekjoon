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
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> al = new ArrayList<>(n); // 노드 수
//		al.add(null);
//		al.add(new ArrayList<>(2));
		for(int i=0;i<n;i++)
			al.add(new ArrayList<>(2));
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int parent = st.nextToken().charAt(0)-'A';
			while(st.hasMoreTokens()) {
				char node = st.nextToken().charAt(0);
				if(node=='.')
					al.get(parent).add(null);
				else
					al.get(parent).add(node-'A');
			}
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		//전위 순회
//		q.push(0);
//		while(!q.isEmpty()) {
//			int now = q.pop();
//			char c = (char) ('A'+now);
//			ssb.append(c);
//			if(al.get(now).get(1)!=null)
//				q.push(al.get(now).get(1));
//			if(al.get(now).get(0)!=null)
//				q.push(al.get(now).get(0));
//		}
		q.push(0);
		boolean[] visited = new boolean[n];
		while(!q.isEmpty()) {
			int now = q.pop();
			char c = (char) ('A'+now);
			if((al.get(now).get(1)==null&&al.get(now).get(0)==null)||visited[now]) {
				ssb.append(c);
				continue;
			}
			if(al.get(now).get(1)!=null) {
				q.push(al.get(now).get(1));
			}
			if(al.get(now).get(0)!=null) {
				q.push(al.get(now).get(0));
			}
			q.push(now);
			visited[now]=true;
		}
		ssb.append('\n');
		//중위 순회
		q.push(0);
		visited = new boolean[n];
		while(!q.isEmpty()) {
			int now = q.pop();
			char c = (char) ('A'+now);
			if((al.get(now).get(1)==null&&al.get(now).get(0)==null)||visited[now]) {
				ssb.append(c);
				continue;
			}
			if(al.get(now).get(1)!=null) {
				q.push(al.get(now).get(1));
			}
			q.push(now);
			visited[now]=true;
			if(al.get(now).get(0)!=null) {
				q.push(al.get(now).get(0));
			}
		}
		ssb.append('\n');
		//후위 순회
		q.push(0);
		visited = new boolean[n];
		while(!q.isEmpty()) {
			int now = q.pop();
			char c = (char) ('A'+now);
			if((al.get(now).get(1)==null&&al.get(now).get(0)==null)||visited[now]) {
				ssb.append(c);
				continue;
			}
			q.push(now);
			visited[now]=true;
			if(al.get(now).get(1)!=null) {
				q.push(al.get(now).get(1));
			}
			if(al.get(now).get(0)!=null) {
				q.push(al.get(now).get(0));
			}
		}
		
		bw.write(ssb.toString());
        bw.flush();
        bw.close();
        br.close();
	}  
}