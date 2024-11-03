import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    private static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op.equals("0")) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            nodes[rootB] = rootA;
        }
    }
    private static int find(int n) {
        if (nodes[n] == n) {
            return n;
        }
        return nodes[n] = find(nodes[n]);
    }
}