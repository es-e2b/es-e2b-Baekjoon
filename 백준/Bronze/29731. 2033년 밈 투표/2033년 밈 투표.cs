#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        HashSet<string> list = new HashSet<string>();
        list.Add("Never gonna give you up");
        list.Add("Never gonna let you down");
        list.Add("Never gonna run around and desert you");
        list.Add("Never gonna make you cry");
        list.Add("Never gonna say goodbye");
        list.Add("Never gonna tell a lie and hurt you");
        list.Add("Never gonna stop");
        var N = int.Parse(sr.ReadLine());
        for (int i = 0; i < N; i++) {
            if (!list.Contains(sr.ReadLine()))
            {
                sb.Append("Yes");
                break;
            }
        }
        if (sb.Length == 0)
            sb.Append("No");
        sw.WriteLine(sb);
        sw.Flush();
    }
}