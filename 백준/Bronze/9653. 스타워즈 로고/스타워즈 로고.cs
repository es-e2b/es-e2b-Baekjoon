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
        sb.AppendLine("    8888888888  888    88888");
        sb.AppendLine("   88     88   88 88   88  88");
        sb.AppendLine("    8888  88  88   88  88888");
        sb.AppendLine("       88 88 888888888 88   88");
        sb.AppendLine("88888888  88 88     88 88    888888");
        sb.AppendLine("");
        sb.AppendLine("88  88  88   888    88888    888888");
        sb.AppendLine("88  88  88  88 88   88  88  88");
        sb.AppendLine("88 8888 88 88   88  88888    8888");
        sb.AppendLine(" 888  888 888888888 88  88      88");
        sb.AppendLine("  88  88  88     88 88   88888888");
        sw.WriteLine(sb);
        sw.Flush();
    }
}