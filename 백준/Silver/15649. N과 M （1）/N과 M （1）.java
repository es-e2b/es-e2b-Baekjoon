import java.io.*;
import java.util.*;
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static StringTokenizer st;
	static int[] arr;
	static int[] ans;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr=new int[n];
		ans=new int[m];
		for(int i=0;i<n;i++)
			arr[i]=i+1;
		f(0);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
	static void f(int count) {
		if(count==m) {
			for(int i : ans)
				sb.append(i+" ");
			sb.append('\n');
			return;
		}
		for(int i=0;i<n;i++) {
			boolean isUsed=false;
			for(int j=0;j<count;j++)
				if(arr[i]==ans[j])
					isUsed=true;
			if(isUsed)
				continue;
			ans[count]=arr[i];
			f(count+1);
		}
	}
}