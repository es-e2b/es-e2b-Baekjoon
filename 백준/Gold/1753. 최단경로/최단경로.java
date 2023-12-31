import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<HashMap<Integer, Integer>> al = new ArrayList<>();
    static int N, M, start;
    static int[] cost;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class AStarNode implements Comparable<AStarNode> {
        int vertex;
        int cost;

        public AStarNode(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(AStarNode o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        al.add(new HashMap<>());
        N = read();
        M = read();
        start = read();
        for (int i = 0; i < N; i++) {
            al.add(new HashMap<>());
        }
        for (int i = 0; i < M; i++) {
            int v = read();
            int w = read();
            int cost = read();
            al.get(v).put(w, Math.min(al.get(v).getOrDefault(w, cost), cost));
        }
        cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<AStarNode> pq = new PriorityQueue<>();
        pq.add(new AStarNode(start, 0));
        cost[start] = 0;
        while (!pq.isEmpty()) {
            AStarNode node = pq.poll();
            int now = node.vertex;
            for (Map.Entry<Integer, Integer> target : al.get(now).entrySet()) {
                int updatedCost = cost[now] + target.getValue();
                if (updatedCost < cost[target.getKey()]) {
                    cost[target.getKey()] = updatedCost;
                    pq.add(new AStarNode(target.getKey(), updatedCost));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (cost[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(cost[i] + "\n");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }
}