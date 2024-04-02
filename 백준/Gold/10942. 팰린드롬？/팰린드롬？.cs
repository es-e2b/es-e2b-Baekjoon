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
        int N = ReadInt();
        int[] arr=ReadIntArray();
        int M = ReadInt();
        while(M-->0)
        {
            int[] now=ReadIntArray();
            for(int left = now[0]-1, right = now[1]-1; left<right;left++, right--)
            {
                if(arr[left]!=arr[right])
                {
                    goto outerloop;
                }
            }
            sb.AppendLine("1");
            continue;
            outerloop:sb.AppendLine("0");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}