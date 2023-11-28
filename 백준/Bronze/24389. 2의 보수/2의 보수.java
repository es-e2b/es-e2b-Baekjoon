import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = ~n+1;
		int count=0;
		for(int i=0;i<32;i++) {
			if((n&1)!=(m&1))
				count++;
			n>>=1;
			m>>=1;
		}
		sb.append(count);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}