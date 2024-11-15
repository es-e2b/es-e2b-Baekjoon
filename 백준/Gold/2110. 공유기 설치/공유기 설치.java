import java.io.*;
import java.util.*;

public class Main
{
	static StringBuilder sb=new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int read() throws Exception
	{
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
	public void print() throws IOException
	{
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();		
	}
	private static int[] array;
	private static int N,C;
	private void Run() throws Exception
	{
		N=read();
		C=read();
		array=new int[N];
		for(int i=0;i<N;i++)
		{
			array[i]=read();
		}
		Arrays.sort(array);
		int max=array[N-1]-array[0];
		int min=1;
		int answer=0;
		while(min<=max)
		{
			int mid=(max-min)/2 + min;
			int count = count(mid);
			if(count>=C)
			{
				answer=Math.max(answer, mid);
				min=mid+1;
			}
			else
			{
				max=mid-1;
			}
		}
		sb.append(answer);
	}
	private int count(int mid)
	{
		int now=array[0];
		int count=1;
		for(int i=1;i<N;i++)
		{
			if(array[i]-now>=mid)
			{
				count++;
				now=array[i];
			}
		}
		return count;
	}
}