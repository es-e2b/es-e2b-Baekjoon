import java.io.*;
import java.util.*;
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int[] ans;
	static boolean[] visited;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans=new int[m+1];
		visited=new boolean[n+1];
		f(1);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static void f(int count) {
        if (count==m+1) {
            for (int i=1; i<=m; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i=1; i<=n; i++) {
                if (!visited[i]) {
                    ans[count]=i;
                    visited[i]=true;
                    f(count+1);
                    visited[i]=false;
                }
            }
        }
	}
}