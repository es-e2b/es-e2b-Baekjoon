import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	
public class Main {
	static class Graph_2{
		int V;
		ArrayList<ArrayList<Integer>> adj;
		public Graph_2(int v) {
			V=v;
			adj=new ArrayList<>(v);
			for(int i=0;i<v;i++) {
				adj.add(new ArrayList<>());
			}
		}
		void addEdge(int v, int w) {
			adj.get(v).add(w);
			adj.get(w).add(v);
			Collections.sort(adj.get(v));
			Collections.sort(adj.get(w));
		}
		void DFS(int v) {
			boolean[] visited=new boolean[V];
			Stack<Integer> stack=new Stack<>();
			stack.push(v);
			
			while(!stack.isEmpty()) {
				
				v = stack.pop();
				if(!visited[v]) {
					visited[v]=true;
					System.out.print(v + " ");
				}
				
				for(int i= adj.get(v).size()-1;i>=0;i--)
					if(!visited[adj.get(v).get(i)]) {
						stack.push(adj.get(v).get(i));
					}
			}
		}
		void BFS(int v) {
			boolean[] visited=new boolean[V];
			Queue<Integer> queue=new LinkedList<>();
			
			visited[v]=true;
			queue.offer(v);
			
			while(!queue.isEmpty()) {
				v = queue.poll();
				System.out.print(v + " ");
				
				for(Integer neighbor : adj.get(v))
					if(!visited[neighbor]) {
						visited[neighbor]=true;
						queue.offer(neighbor);
					}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Scanner sc = new Scanner(System.in);
//        StringTokenizer st=new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
        
		Graph_2 Graph = new Graph_2(node+1);
		while(edge-->0) {
			st=new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Graph.addEdge(n, e);
		}
		Graph.DFS(V);
		System.out.println();
		Graph.BFS(V);
		
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}