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
        int N=Read(), M=Read();
        Singer[] singers= new Singer[N+1];
        for(int i=1;i<=N;i++)
        {
            singers[i]=new Singer(i);
        }
        for(int i=0;i<M;i++)
        {
            int num=Read();
            int[] ints=new int[num];
            for(int j=0;j<num;j++)
            {
                ints[j]=Read();
            }
            for(int j=1;j<num;j++)
            {
                int pre=ints[j-1];
                int next=ints[j];
                singers[pre].outdegree.Add(next);
                singers[next].indegree.Add(pre);
            }
        }
        Queue<Singer> pq= new Queue<Singer>();
        bool[] visited= new bool[N+1];
        int unVisted=N;
        for(int i=1;i<=N;i++)
        {
            if(singers[i].indegree.Count==0)
            {
                pq.Enqueue(singers[i]);
                visited[i]=true;
                unVisted--;
            }
        }
        while(pq.Count > 0)
        {
            Singer now=pq.Dequeue();
            if(now.indegree.Count!=0)
            {
                sb.Clear();
                sb.Append(0);
                break;
            }
            sb.AppendLine(now._num.ToString());
            foreach(int i in now.outdegree)
            {
                singers[i].indegree.Remove(now._num);
                if(singers[i].indegree.Count==0)
                {
                    pq.Enqueue(singers[i]);
                    visited[i]=true;
                    unVisted--;
                }
            }
        }
        if(unVisted>0)
        {
            sb.Clear();
            sb.Append(0);
        }
        sw.Write(sb);
        sw.Flush();
    }
    class Singer
    {
        public int _num;
        public List<int> indegree=new List<int>();
        public List<int> outdegree=new List<int>();
        public Singer(int num)
        {
            _num=num;
        }
    }
}