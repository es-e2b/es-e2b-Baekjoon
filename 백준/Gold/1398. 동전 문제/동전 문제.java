import java.io.*;
import java.util.*;

class Main{
	static StringBuilder sb=new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int read() throws Exception{
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	private static long readLong() throws Exception{
		long c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	public static void main(String[] args) throws Exception
	{
		Main main=new Main();
		main.Run();
		main.print();
	}
	public void print() throws IOException {
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();		
	}
	
	private void Run() throws Exception{
		int[] dp=new int[100];
		for(int i=0;i<100;i++)
		{
			int now=1;
			if(i-now>=0)
			{
				dp[i]=dp[i-now]+1;
			}
			now=10;
			if(i-now>=0)
			{
				dp[i]=Math.min(dp[i], dp[i-now]+1);
			}
			now=25;
			if(i-now>=0)
			{
				dp[i]=Math.min(dp[i], dp[i-now]+1);
			}
		}
		int T=read();
		while(T-->0)
		{
			int answer=0;
			long now=readLong();
			while(now>0)
			{
				answer+=dp[(int)(now%100)];
				now/=100;
			}
			sb.append(answer+"\n");
		}
	}
}