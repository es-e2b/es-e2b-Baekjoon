#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    private static int Read()
    {
        int c,n=Console.Read()&15;
        while((c=Console.Read())>32)
        {
            n=(n<<3)+(n<<1)+(c&15);
        }
        return n;
    }
    public static void Main()
    {
        int N=Read();
        int K=Read();
        int[] ints=new int[N];
        bool[] visited=new bool[N];
        for(int i=0;i<N;i++)
        {
            ints[i]=Read();
        }
        int now=0;
        visited[0]=true;
        int count=0;
        while(true)
        {
            now=ints[now];
            count++;
            if(now==K)
            {
                sb.Append(count);
                break;
            }
            if(visited[now])
            {
                sb.Append(-1);
                break;
            }
            visited[now]=true;
        }
        sw.Write(sb);
        sw.Flush();
    }
}