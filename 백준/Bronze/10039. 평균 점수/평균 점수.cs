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
        int sum=0;
        for(int i=0;i<5;i++)
        {
            int now=Read();
            if(now<40)
                now=40;
            sum+=now;
        }
        sb.Append(sum/5);
        sw.WriteLine(sb);
        sw.Flush();
    }
}