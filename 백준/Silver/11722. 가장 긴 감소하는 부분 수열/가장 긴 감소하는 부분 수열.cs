#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        int n = int.Parse(sr.ReadLine());
        int[] arr=sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int[] count = new int[n];
        Array.Fill(count, 1);
        int ans = 1;
        for(int i=1; i<n; i++)
        {
            for(int j = i-1; j >= 0; j--)
            {
                if (arr[j] > arr[i])
                {
                    count[i] = Math.Max(count[i], count[j]+1);
                }
            }
            ans=Math.Max(ans, count[i]);
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}