#nullable disable
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
        string s1=sr.ReadLine();
        string s2=sr.ReadLine();
        string ss1=s1+s2;
        int n1=int.Parse(s1);
        int n2=int.Parse(s2);
        string s3=sr.ReadLine();
        int n3=int.Parse(s3);
        sb.AppendLine((n1+n2-n3).ToString());
        sb.Append(int.Parse(ss1)-n3);

        sw.WriteLine(sb);
        sw.Flush();
    }
}