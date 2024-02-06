#nullable disable
using System.Text;
public static class Program
{
    static int N,M;
    static int[] pre;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        N=int.Parse(sr.ReadLine());
        M=int.Parse(sr.ReadLine());
        pre=new int[N+1];
        PriorityQueue<(int v1, int v2, int c), int> pq=new PriorityQueue<(int v1, int v2, int c), int>();
        while(M-->0)
        {
            var abc=sr.ReadLine().Split().Select(int.Parse).ToArray();
            pq.Enqueue((abc[0], abc[1], abc[2]), abc[2]);
        }
        (int v1, int v2, int c) start=pq.Dequeue();
        pre[start.v2]=start.v1;
        int count=0;
        int sum=0;
        sum+=start.c;
        while(pq.Count>0&&count<N)
        {
            (int v1, int v2, int c) now=pq.Dequeue();
            int parent1=now.v1;
            while(pre[parent1]!=0)
            {
                parent1=pre[parent1];
            }
            int parent2=now.v2;
            while(pre[parent2]!=0)
            {
                parent2=pre[parent2];
            }
            if(parent1==parent2)continue;
            pre[parent2]=parent1;
            pre[now.v2]=parent1;
            sum+=now.c;
            count++;
        }
        sb.Append(sum);
        sw.WriteLine(sb);
        sw.Flush();
    }
}