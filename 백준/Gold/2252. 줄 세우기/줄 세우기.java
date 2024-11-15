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
	private void Run() throws Exception
	{
		int N=read(), M=read();
		Node[] students=new Node[N+1];
		for(int i=1;i<=N;i++)
		{
			students[i]=new Node();
			students[i].order=i;
		}
		while(M-->0)
		{
			int n1=read(), n2=read();
			students[n1].Outdegree.add(students[n2]);
			students[n2].IndegreeCount++;
		}
		Queue<Node> line=new ArrayDeque<>();
		for(int i=1;i<=N;i++)
		{
			if(students[i].IndegreeCount==0)
				line.offer(students[i]);
		}
		while(!line.isEmpty())
		{
			Node now=line.peek();
			for(Node node : now.Outdegree)
			{
				node.IndegreeCount--;
				if(node.IndegreeCount==0)
				{
					line.offer(node);
				}
			}
			sb.append(line.poll().order).append(" ");
		}
	}
	private class Node
	{
		public int order;
		public int IndegreeCount=0;
		public ArrayList<Node> Outdegree=new ArrayList<>();
	}
}