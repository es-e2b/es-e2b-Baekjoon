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
		String s=br.readLine();
		switch(s) {
		case "NLCS":
			sb.append("North London Collegiate School");
			break;
		case "BHA":
			sb.append("Branksome Hall Asia");
			break;
		case "KIS":
			sb.append("Korea International School");
			break;
		case "SJA":
			sb.append("St. Johnsbury Academy");
			break;
		}
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}