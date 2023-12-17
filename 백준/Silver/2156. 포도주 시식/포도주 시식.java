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
		int T=read();
		int[] arr = new int[T+1];
		int[] ans = new int[T+1];
		for(int i=1;i<=T;i++) {
			arr[i]=read();
		}
		ans[1]=arr[1];
		if(T>=2)
			ans[2]=arr[1]+arr[2];
		for(int i=3;i<=T;i++) {
				ans[i]=Math.max(ans[i-2], ans[i-3]+arr[i-1])+arr[i];
				ans[i]=Math.max(ans[i-1], ans[i]);
		}
		sb.append(ans[T]);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}