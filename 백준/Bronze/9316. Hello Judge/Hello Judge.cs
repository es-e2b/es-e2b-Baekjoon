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
        int n = ReadInt();
        for(int i=1;i<=n;i++)
        {
            sb.AppendLine("Hello World, Judge "+i+"!");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}