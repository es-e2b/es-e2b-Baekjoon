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
        int n=ReadInt();
        for(int i=0;i<2*n-1;i++)
        {
            int tmp=i;
            if(i>=n)
            {
                i=n-i%n-2;
            }
            for(int j=0;j<i;j++)
            {
                sb.Append(' ');
            }
            for(int j=0;j<2*n-1-2*i;j++)
            {
                sb.Append('*');
            }
            sb.AppendLine();
            i=tmp;
        }
        sw.Write(sb);
        sw.Flush();
    }
}