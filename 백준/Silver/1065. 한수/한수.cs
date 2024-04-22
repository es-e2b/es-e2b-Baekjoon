#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    public static void Main()
    {
        int N=ReadInt();
        int ans=0;
        for(int i=1;i<=N;i++)
        {
            if(i<100)
            {
                ans++;
                continue;
            }
            int now=i;
            int n1=now%10;
            now/=10;
            int n2=now%10;
            now/=10;
            int n3=now;
            if(n1-n2==n2-n3)
            {
                ans++;
            }
        }
        sb.Append(ans);
        sw.Write(sb);
        sw.Flush();
    }
}