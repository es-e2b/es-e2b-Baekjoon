import java.io.*;

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
		int n=read();
		int k=read();
		int[] dp=new int[k+1];
		while(n-->0)
		{
			int now=read();
			if(now<=k)
				dp[now]+=1;
			for(int j=now;j<=k;j++)
			{
				dp[j]+=dp[j-now];
			}
		}
		sb.append(dp[k]);
	}
}