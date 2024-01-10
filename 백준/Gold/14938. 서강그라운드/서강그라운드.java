import java.util.*;
import java.io.*;

public class Main {
	static int N,M,R;
	static int[] item;
	static ArrayList<ArrayList<int[]>> al=new ArrayList<>();
	static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c,n=System.in.read()&15;
        while ((c=System.in.read())>32)
            n=(n<<3)+(n<<1)+(c&15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	N=read(); M=read(); R=read();
    	item=new int[N+1];
    	for(int i=1;i<=N;i++)
    		item[i]=read();
    	for(int i=0;i<=N;i++)
    		al.add(new ArrayList<>());
    	
    	for(int i=0;i<R;i++) {
    		int v1=read(), v2=read(), cost=read();
    		al.get(v1).add(new int[] {v2, cost});
    		al.get(v2).add(new int[] {v1, cost});
    	}
    	int ans=0;
    	for(int i=1;i<=N;i++) {
	    	visited=new boolean[N+1];
	    	PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>() {
	    		@Override
	    		public int compare(int[] o1, int[] o2) {
	    			return o1[1]-o2[1];
	    		}
	    	});
	    	pq.add(new int[] {i,0});
	    	int count=0;
	    	while(!pq.isEmpty()) {
	    		int[] now=pq.poll();
	    		if(!visited[now[0]])
	    			count+=item[now[0]];
	    		visited[now[0]]=true;
	    		for(int[] target:al.get(now[0])) {
	    			int nCost=now[1]+target[1];
	    			if(visited[target[0]]||nCost>M)continue;
	    			pq.add(new int[] {target[0],nCost});
	    		}
	    	}
	    	ans=Math.max(ans, count);
    	}
    	sb.append(ans);
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}