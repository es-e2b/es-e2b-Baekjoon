#nullable disable
using System.Text;
public static class Program
{
    static int N, ans;
    static int[] students, teams, counts;
    static bool[] visited;
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
        int T=Read();
        while(T-->0)
        {
            N=Read();
            students=new int[N+1];
            visited=new bool[N+1];
            teams=new int[N+1];
            counts=new int[N+1];
            ans=0;
            for(int i=1;i<=N;i++)
            {
                students[i]=Read();
            }
            for(int i=1, team=1;i<=N;i++)
            {
                if(visited[i])continue;
                dfs(i,team,0);
                team++;
            }
            sb.AppendLine(ans.ToString());
        }
        sw.Write(sb);
        sw.Flush();
    }
    static void dfs(int now, int team, int count)
    {
        if(visited[now])
        {
            if(teams[now]==team)
            {
                ans+=counts[now];
                return;
            }
            ans+=count;
            return;
        }
        visited[now]=true;
        teams[now]=team;
        counts[now]=count;
        dfs(students[now], team, count+1);
    }
}