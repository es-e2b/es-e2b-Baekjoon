#nullable disable
using System.Text;
public static class Program
{
    static int[] ints=new int[9];
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
        long s=long.Parse(sr.ReadLine());
        long sum=0;
        int i=1;
        for(int k=1;;k++)
        {
            sum+=k;
            if(sum>s)break;
            i++;
        }
        sb.Append(i-1);
        sw.Write(sb);
        sw.Flush();
    }
}