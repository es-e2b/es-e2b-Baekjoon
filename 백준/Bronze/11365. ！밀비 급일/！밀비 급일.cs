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
        while(true)
        {
            string s=Console.ReadLine();
            if(s=="END")
                break;
            for(int i=s.Length-1;i>=0;i--)
            {
                sb.Append(s[i]);
            }
            sb.AppendLine();
        }

        sw.WriteLine(sb);
        sw.Flush();
    }
}