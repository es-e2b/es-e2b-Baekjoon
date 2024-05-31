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
        int a=Read();
        int sum=0;
        for(int i=0;i<a;i++)
        {
            if(Read()==1)
            {
                sum++;
            }
        }
        sb.Append(sum>a/2?"Junhee is cute!":"Junhee is not cute!");
        sw.Write(sb);
        sw.Flush();
    }
}