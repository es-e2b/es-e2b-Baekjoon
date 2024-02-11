#nullable disable
using System.Numerics;
using System.Text;
public static class Program
{
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        BigInteger n=0;
        for(int i=0;i<5;i++)
            n+=BigInteger.Parse(sr.ReadLine());
        sb.Append(n);
        sw.WriteLine(sb);
        sw.Flush();
    }
}