#nullable disable
using System.Text;
public static class Program
{
    static long[] input;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        int N=ReadInt();
        while(N-->0)
        {
            int l=sr.ReadLine().Length;
            if(l>=6&&l<=9)
                sb.AppendLine("yes");
            else
                sb.AppendLine("no");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}