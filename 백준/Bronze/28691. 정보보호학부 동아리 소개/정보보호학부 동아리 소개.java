import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
public class Main {
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
	private static int read() throws Exception{
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
//		int T=read();
		HashMap<String, String> map=new HashMap<>();
		map.put("M", "MatKor");
		map.put("W", "WiCys");
		map.put("C", "CyKor");
		map.put("A", "AlKor");
		map.put("$", "$clear");
		sb.append(map.get(br.readLine()));
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}