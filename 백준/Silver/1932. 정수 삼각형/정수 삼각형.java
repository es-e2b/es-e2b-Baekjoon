import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] tri=new int[n][];
		tri[0]=new int[1];
		tri[0][0]=m;
		int max=0;
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			tri[i]=new int[i+1];
			for(int j=0;j<=i;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(j==0)
					tri[i][j]=tri[i-1][j]+tmp;
				if(j>0&&j<i)
					tri[i][j]=Math.max(tri[i-1][j-1], tri[i-1][j])+tmp;
				if(j==i)
					tri[i][j]=tri[i-1][j-1]+tmp;
			}
		}
		for(int i=0;i<n;i++)
			max=Math.max(max, tri[n-1][i]);
		sb.append(max);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}