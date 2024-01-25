#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        var N = int.Parse(sr.ReadLine());
        PriorityQueue<int, int> pq=new PriorityQueue<int,int>();
        while(N-->0){
            int now=int.Parse(sr.ReadLine());
            pq.Enqueue(now, now);
        }
        int ans=0;
        while(pq.Count>1){
            int now1=pq.Dequeue();
            int now2=pq.Dequeue();
            int sum=now1+now2;
            ans+=sum;
            pq.Enqueue(sum,sum);
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}