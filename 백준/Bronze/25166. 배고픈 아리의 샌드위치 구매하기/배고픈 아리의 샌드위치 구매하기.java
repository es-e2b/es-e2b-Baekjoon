import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = (1<<10)-1;
		sb.append(a>=n?"No thanks" : ((n-a)&m)==n-a?"Thanks":"Impossible");
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}