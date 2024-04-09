#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    public static void Main()
    {
        int[] ints= ReadIntArray();
        int n=0;
        int ans=0;
        for(int i=1;i<=ints[0];i++)
        {
            if(ints[0]%i==0)
            {
                n++;
                if(n==ints[1])
                {
                    ans=i;
                    break;
                }
            }
        }
        sb.Append(ans);
        sw.Write(sb);
        sw.Flush();
    }
}