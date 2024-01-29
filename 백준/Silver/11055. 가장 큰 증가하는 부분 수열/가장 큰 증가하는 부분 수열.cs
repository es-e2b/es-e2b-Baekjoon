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
        int[] sum = new int[n];
        sum[0] = arr[0];
        int ans = arr[0];
        for(int i=1; i<n; i++)
        {
            sum[i] = arr[i];
            for(int j = i; j >= 0; j--)
            {
                if (arr[j] < arr[i])
                {
                    sum[i] = Math.Max(sum[i], sum[j] + arr[i]);
                }
            }
            ans=Math.Max(ans, sum[i]);
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}