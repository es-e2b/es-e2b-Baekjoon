import java.io.*;
import java.util.*;

public class Main {
	static int N, M, must1,must2;
	static ArrayList<ArrayList<int[]>> al=new ArrayList<>();
	static int[] cost;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
    	N=read(); M=read();
    	al.add(new ArrayList<>()); //사용하지 않을 0번 정점.
    	for(int i=1;i<=N;i++) {
    		al.add(new ArrayList<>());
    		al.get(i).add(new int[] {i, 0});
    	}
    	for(int i=0;i<M;i++) {
    		int start=read();
    		int end=read();
    		int cost=read();
    		al.get(start).add(new int[] {end, cost});
    		al.get(end).add(new int[] {start, cost});
    	}
    	must1=read(); must2=read();
    	
    	cost=new int[N+1];
    	Arrays.fill(cost, -1);
    	go(1, must1);
    	if(cost[must1]>=0)
    		go(must1, must2);
    	if(cost[must2]>=0)
    		go(must2, N);
    	int route1=cost[N];
    	
    	cost=new int[N+1];
    	Arrays.fill(cost, -1);
    	go(1, must2);
    	if(cost[must2]>=0)
    		go(must2, must1);
    	if(cost[must1]>=0)
    		go(must1, N);
    	int route2=cost[N];
    	
    	if(route1<0 && route2<0)
    		sb.append(-1);
    	else if(route1>=0 && route2>=0)
    		sb.append(Math.min(route1, route2));
    	else
    		sb.append(Math.max(route1, route2));

        bw.append(sb);
        bw.flush();
        bw.close();
    }
    static void go(int start, int end) { // start에서 end로 가는 최단 경로 저장
    	PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
    	});
    	q.add(new int[] {start, 0});
    	while(!q.isEmpty()) {
    		int[] now=q.poll();
    		for(int[] target:al.get(now[0])) {
    			int nowCost=(cost[now[0]]<0)?0:cost[now[0]];
    			int newCost=target[1]+nowCost;
    			if(cost[target[0]]!=-1&&newCost>=cost[target[0]])continue;
    			cost[target[0]]=newCost;
    			q.add(target);
    		}
    	}
    	int endCost=cost[end];
    	cost=new int[N+1];
    	Arrays.fill(cost, -1);
    	cost[end]=endCost;
    }
}