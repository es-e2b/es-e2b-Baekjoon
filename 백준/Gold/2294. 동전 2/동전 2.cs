#nullable disable
using System.Text;
public static class Program
{
    static int[] dp, input;
    static HashSet<int> Coin;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        input=ReadIntArray();
        dp=new int[input[1]+1];
        Coin=new HashSet<int>();
        Queue<int> q=new Queue<int>();
        for(int i=0;i<input[0];i++)
        {
            int coin=ReadInt();
            if(coin>input[1])continue;
            Coin.Add(coin);
            q.Enqueue(coin);
            dp[coin]=1;
        }
        while(q.Count>0)
        {
            int now=q.Dequeue();
            if(now==input[1])
            {
                sb.Append(dp[now]);
                break;
            }
            foreach(int coin in Coin)
            {
                int next=now+coin;
                if(next>input[1]||dp[next]>=dp[now])continue;
                q.Enqueue(next);
                dp[next]=dp[now]+1;
            }
        }
        if(dp[input[1]]==0)
            sb.Append(-1);
        sw.WriteLine(sb);
        sw.Flush();
    }
}