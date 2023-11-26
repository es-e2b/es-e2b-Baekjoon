import java.io.*;
import java.util.*;
	
public class Main {
	static StringBuilder ssb=new StringBuilder();
	static boolean[] visited;
	static int[] arr;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			visited[i]=true;
			dfs(arr[i], String.valueOf(arr[i]), 1);
			visited[i]=false;
		}
		bw.append(ssb);
        bw.flush();
        bw.close();
        br.close();
	}  
	static void dfs(int N, String ans, int count) {
		if(count<m) {
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					dfs(arr[i], ans+" "+arr[i],count+1);
					visited[i]=false;
				}
			}
		}
		else
			System.out.println(ans);
	}
}