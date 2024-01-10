import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	static int N,M;
	static ArrayList<HashMap<Integer, Integer>> al=new ArrayList<>();
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
    	N=read(); M=read();
    	for(int i=0;i<=N;i++)
    		al.add(new HashMap<>());
    	
    	for(int i=0;i<M;i++) {
    		int v1=read(), v2=read(), cost=read();
    		if(al.get(v1).containsKey(v2))
    			cost=Math.min(al.get(v1).get(v2), cost);
    		al.get(v1).put(v2, cost);
    	}
    	int start=read(), end=read();
	    visited=new boolean[N+1];
	    int[] cost=new int[N+1];
	    int[] way=new int[N+1];
	    Arrays.fill(cost, Integer.MAX_VALUE);
	    PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<>() {
	    	@Override
	    	public int compare(Integer o1, Integer o2) {
	    		return cost[o1]-cost[o2];
	    	}
	    });
	    pq.add(start);
	    cost[start]=0;
	    while(!pq.isEmpty()) {
	    	int now=pq.poll();
	    	visited[now]=true;
	    	if(now==end) {
	    		sb.append(cost[end]+"\n");
	    		ArrayDeque<Integer> q=new ArrayDeque<>();
	    		int count=0;
	    		while(true) {
	    			count++;
	    			q.push(now);
	    			now=way[now];
	    			if(now==0)
	    				break;
	    		}
	    		sb.append(count+"\n");
	    		while(!q.isEmpty())
	    			sb.append(q.poll()+" ");
	    		break;
	    	}
	    	for(Entry<Integer, Integer> entry:al.get(now).entrySet()) {
	    		int key=entry.getKey(), value=entry.getValue();
	    		if(visited[key]||cost[key]<=cost[now]+value)continue;
	    		cost[key]=cost[now]+value;
	    		pq.add(key);
	    		way[key]=now;
	    	}
	    }
        bw.append(sb);
        bw.flush();
        bw.close();
    }
}