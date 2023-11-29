import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static int[] set;
	static boolean[] visited;
	static boolean[] visited1;
	static boolean[] visited2;
	static int n;
	static int[] ans;
	static boolean searched=false;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		visited=new boolean[n];
		visited1=new boolean[2*n-1];
		visited2=new boolean[2*n-1];
		set = new int[n];
		ans = new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			set[i]=Integer.parseInt(st.nextToken());
			if(set[i]>0) {
				int s=set[i]-1;
				visited[s]=true;
				visited1[i+s]=true;
				visited2[i-s+n-1]=true;
				ans[i]=s;
			}
		}
		if(!f(0))
			sb.append(-1);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static boolean f(int i) {
		if(i==n) {
			for(int k : ans)
				sb.append((k+1)+" ");
			sb.append('\n');
			return true;
		}
		for(int j=0;j<n;j++) {
			if(set[i]!=0) {
				j=set[i]-1;
                if (f(i + 1)) {
                    return true;
                }
				break;
			}
			if(visited[j]||visited1[i+j]||visited2[i-j+n-1]) {
				continue;
			}
			visited[j]=true;
			visited1[i+j]=true;
			visited2[i-j+n-1]=true;
			ans[i]=j;
            if (f(i + 1)) {
                return true;
            }
			visited[j]=false;
			visited1[i+j]=false;
			visited2[i-j+n-1]=false;
		}
		return false;
	}
}