#nullable disable
using System.Text;
public static class Program
{
        private static int Read()
    {
        int c,n=Console.Read()&15;
        while((c=Console.Read())>32)
        {
            n=(n<<3)+(n<<1)+(c&15);
        }
        return n;
    }
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    public static void Main()
    {
        int n=Read();
        int[] pre=new int[n+1];
        int m=Read();
        for(int i=0;i<m;i++)
        {
            int spot1=Read()+1;
            int spot2=Read()+1;

            int root1=spot1;
            int root2=spot2;

            while(pre[root1]!=0)
            {
                root1=pre[root1];
            }
            while(pre[root2]!=0)
            {
                root2=pre[root2];
            }
            if(root1==root2)
            {
                sb.Append(i+1);
                break;
            }
            pre[root1]=root2;
            pre[spot1]=root2;
        }
        if(sb.Length==0)
        {
            sb.Append(0);
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}