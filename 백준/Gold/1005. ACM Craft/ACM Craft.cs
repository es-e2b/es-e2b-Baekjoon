#nullable disable
using System.Text;
public static class Program
{
    static int N,K;
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    public static void Main()
    {
        int T=ReadInt();
        while(T-->0)
        {
            int[] ints=ReadIntArray();
            N=ints[0];
            K=ints[1];
            int[] time=ReadIntArray();
            Node[] building = new Node[N];
            for(int i=0; i<N; i++)
            {
                building[i]=new Node(time[i]);
            }
            for(int i=0; i<K;i++)
            {
                ints=ReadIntArray();
                building[ints[0]-1].outdegree.Add(building[ints[1]-1]);
                building[ints[1]-1].indegree.Add(building[ints[0]-1]);
            }
            Node last=building[ReadInt()-1];
            Queue<Node> nodes=new Queue<Node>();
            bool[] visited=new bool[N];
            for(int i=0; i<N;i++)
            {
                if(building[i].indegree.Count==0)
                {
                    nodes.Enqueue(building[i]);
                    visited[i]=true;
                }
            }
            while(nodes.Count>0)
            {
                Node now = nodes.Dequeue();
                if(now==last)
                {
                    sb.AppendLine((now.time+now.delay).ToString());
                    break;
                }
                foreach(Node next in now.outdegree)
                {
                    next.delay = Math.Max(next.delay,now.time+now.delay);
                    next.indegree.Remove(now);
                }
                for(int i=0; i<N;i++)
                {
                    if(!visited[i]&&building[i].indegree.Count==0)
                    {
                        nodes.Enqueue(building[i]);
                        visited[i]=true;
                    }
                }
            }
        }
        sw.Write(sb);
        sw.Flush();
    }
    class Node
    {
        public int time;
        public int delay;
        public List<Node> indegree=new List<Node>();
        public List<Node> outdegree=new List<Node>();
        public Node(int time)
        {
            this.time = time;
        }
    }
}