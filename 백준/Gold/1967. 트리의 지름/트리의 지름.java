import java.io.*;
import java.util.*;

public class Main {
	static int max;
	static ArrayList<ArrayList<int[]>> al = new ArrayList<>();
	static HashSet<Integer> leaf=new HashSet<>();
	static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	int N=read();
    	al.add(new ArrayList<>());
    	for(int i=0;i<N;i++)
    		al.add(new ArrayList<>());
    	for(int i=1;i<N;i++) {
    		int parent=read();
    		int child=read();
    		int cost=read();
    		al.get(parent).add(new int[] {child, cost});
    		al.get(child).add(new int[] {parent, cost});
    	}
    	for(int i=1;i<=N;i++) {
    		if(al.get(i).size()<=1)
    			leaf.add(i);
    	}
    	max=0;
    	for(int start:leaf) {
    		visited=new boolean[N+1];
    		visited[start]=true;
    		dfs(start, 0);
    	}
    	sb.append(max);
        bw.append(sb);
        bw.flush();
        bw.close();
    }
    static void dfs(int now, int cost) {
    	ArrayList<int[]> idx=al.get(now);
    	for(int[] target:idx) {
    		if(visited[target[0]])continue;
    		visited[target[0]]=true;
    		dfs(target[0], cost+target[1]);
    	}

    	if(idx.size()<=1) {
    		max=Math.max(max, cost);
    	}
    }
}