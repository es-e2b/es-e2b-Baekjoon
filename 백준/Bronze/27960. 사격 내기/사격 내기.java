import java.io.*;
import java.util.*;
	
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		sb.append(Integer.parseInt(st.nextToken()) ^ Integer.parseInt(st.nextToken()));
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}