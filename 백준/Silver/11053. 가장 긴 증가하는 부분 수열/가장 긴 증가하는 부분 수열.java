
import java.io.*;
import java.util.*;
	
public class Main {
	private static int read() throws Exception
    {
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
		int N=read();
		int[] arr=new int[N];
		int[] count=new int[N];
		arr[0]=read();
		int max=0;
//		sb.append(1+" ");
		for(int i=1;i<N;i++){
			arr[i]=read();
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i])
					count[i]=Math.max(count[i], count[j]+1);
				max=Math.max(max, count[i]);
			}
//			sb.append(count[i]+" ");
		}
//		sb.append('\n');
		sb.append(max+1);
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}