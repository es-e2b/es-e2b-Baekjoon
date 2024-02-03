#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
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
        long ans=0;
        List<(int c, int v)> item=new List<(int c, int v)>();
        while(N-->0)
        {
            item.Add((Read(), Read()));
        }
        item.Sort(Comparer<(int c, int v)>.Create((o1,o2)=>
        {
            return o1.c==o2.c?o2.v-o1.v:o1.c-o2.c;
        }));
        PriorityQueue<int, int> bag=new PriorityQueue<int, int>();
        while(K-->0)
        {
            int nc=Read();
            bag.Enqueue(nc,nc);
        }
        int i=0;
        PriorityQueue<int, int> steal=new PriorityQueue<int, int>();
        while (bag.Count > 0)
        {
            int now = bag.Dequeue();
            while(i<item.Count)
            {
                if(item[i].c<=now)
                {
                    steal.Enqueue(item[i].v,item[i].v*-1);
                    i++;
                }
                else
                    break;
            }
            if(steal.Count>0)
                ans+=steal.Dequeue();
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}