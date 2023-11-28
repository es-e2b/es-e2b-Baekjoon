import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] parent =new int[n+1];
		boolean[] visited=new boolean[n+1];
		ArrayList<Integer>[] al = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			al[i]=new ArrayList<>();
		}
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			al[n1].add(n2);
			al[n2].add(n1);
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.push(1);
		visited[1]=true;
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int i=0;i<al[now].size();i++) {
				int tmp=al[now].get(i);
				if(!visited[tmp]) {
					parent[tmp]=now;
					visited[tmp]=true;
					q.offer(tmp);
				}
			}
		}
		for(int i=2;i<parent.length;i++)
			sb.append(parent[i]).append('\n');
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}