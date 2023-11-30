import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static int n;
	static int[][] home;
	static int[][] ans;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		home=new int[n][3];
		ans=new int[n][3];
		for(int i=0;i<n;i++) {
			String[] s=br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				home[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<3;i++)
			ans[0][i]=home[0][i];
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				ans[i][j]=home[i][j]+Math.min(ans[i-1][(j+1)%3], ans[i-1][(j+2)%3]);
			}
		}
		int max=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			max=Math.min(max, ans[n-1][i]);
		}
		sb.append(max);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}