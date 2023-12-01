import java.io.*;
import java.util.*;
import java.util.Map.Entry;
	
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
		int[][] arr=new int[N][3];
		for(int i=0;i<N;i++)
			for(int j=0;j<3;j++)
				arr[i][j]=read();
		int[][] min=new int[N][3];
		int[][] max=new int[N][3];
		for(int j=0;j<3;j++) {
			min[0][j]=max[0][j]=arr[0][j];
		}
		for(int i=1;i<N;i++) {
			min[i][0]=Math.min(min[i-1][1],min[i-1][0])+arr[i][0];
			min[i][1]=Math.min(Math.min(min[i-1][1],min[i-1][0]),min[i-1][2])+arr[i][1];
			min[i][2]=Math.min(min[i-1][1],min[i-1][2])+arr[i][2];
			
			max[i][0]=Math.max(max[i-1][0], max[i-1][1])+arr[i][0];
			max[i][1]=Math.max(Math.max(max[i-1][0], max[i-1][1]),max[i-1][2])+arr[i][1];
			max[i][2]=Math.max(max[i-1][2], max[i-1][1])+arr[i][2];
		}
		sb.append(Math.max(Math.max(max[N-1][0], max[N-1][1]),max[N-1][2])).append(' ');
		sb.append(Math.min(Math.min(min[N-1][1],min[N-1][0]),min[N-1][2]));
		
		
		bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
	}
}