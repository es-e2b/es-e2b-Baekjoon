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
            string l=sr.ReadLine();
            if(l=="N"||l=="n")
                sb.AppendLine("Naver D2");
            else
                sb.AppendLine("Naver Whale");
        sw.WriteLine(sb);
        sw.Flush();
    }
}