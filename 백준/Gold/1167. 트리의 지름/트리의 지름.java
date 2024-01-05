import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	int V=read();
    	ArrayList<ArrayList<int[]>> al=new ArrayList<>();
    	HashSet<Integer> leaf=new HashSet<>();
    	for(int i=0;i<=V;i++)
    		al.add(new ArrayList<>());
    	for(int i=1;i<=V;i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		int n=Integer.parseInt(st.nextToken());
    		ArrayList<int[]> v=al.get(n);
    		while(true){
    			int next=Integer.parseInt(st.nextToken());
    			if(next<0)break;
    			v.add(new int[] {next,Integer.parseInt(st.nextToken())});
    		}
    		if(v.size()==1) {
    			leaf.add(n);
    		}
    	}
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
    	});
    	boolean[] visited=new boolean[V+1];
    	q.add(new int[] {1,0});
    	visited[1]=true;
    	while(!q.isEmpty()) {
    		int[] now=q.poll();
    		if(leaf.contains(now[0])) {
    			pq.add(now);
    		}
    		ArrayList<int[]> v=al.get(now[0]);
    		for(int[] target:v) {
    			if(visited[target[0]])continue;
    			q.add(new int[] {target[0], target[1]+now[1]});
    			visited[target[0]]=true;
    		}
    	}
    	visited=new boolean[V+1];
    	int[] tmp=pq.poll();
    	q.add(new int[] {tmp[0],0});
    	visited[tmp[0]]=true;
    	while(!q.isEmpty()) {
    		int[] now=q.poll();
    		if(leaf.contains(now[0])) {
    			pq.add(now);
    		}
    		ArrayList<int[]> v=al.get(now[0]);
    		for(int[] target:v) {
    			if(visited[target[0]])continue;
    			q.add(new int[] {target[0], target[1]+now[1]});
    			visited[target[0]]=true;
    		}
    	}
    	sb.append(pq.poll()[1]);
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}