#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        int[] array = Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
        int V = array[0];
        int E = array[1];
        var edges = new List<(int u, int v, int w)>(E);
        for (int i = 0; i < E; i++)
        {
            var input = Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
            edges.Add((input[0], input[1], input[2]));
        }
        edges.Sort((a, b) => a.w.CompareTo(b.w));

        int[] parent = new int[V + 1];
        int[] rank = new int[V + 1];
        for (int i = 1; i <= V; i++)
            parent[i] = i;

        int Find(int x)
        {
            if (parent[x] != x)
                parent[x] = Find(parent[x]);
            return parent[x];
        }

        bool Union(int a, int b)
        {
            a = Find(a);
            b = Find(b);
            if (a == b) return false;
            if (rank[a] < rank[b])
                parent[a] = b;
            else if (rank[a] > rank[b])
                parent[b] = a;
            else
            {
                parent[b] = a;
                rank[a]++;
            }
            return true;
        }

        long answer = 0;
        int edgeCount = 0;
        foreach (var e in edges)
        {
            if (Union(e.u, e.v))
            {
                answer += e.w;
                edgeCount++;
                if (edgeCount == V - 1) break;
            }
        }

        sb.Append(answer);
        
        sw.Write(sb);
        sw.Flush();
    }
}