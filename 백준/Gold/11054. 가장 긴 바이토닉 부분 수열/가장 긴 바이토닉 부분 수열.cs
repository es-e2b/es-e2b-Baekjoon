#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    private static int Read()
    {
        int c, n = Console.Read() & 15;
        while ((c = Console.Read()) > 32)
        {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
    public static void Main()
    {
        int n = int.Parse(sr.ReadLine());
        int[] arr = sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int[] up = new int[n];
        int[] down = new int[n];
        Array.Fill(up, 1);
        Array.Fill(down, 1);
        int ans = 1;
        for (int i = 1; i < n; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (arr[j] < arr[i])
                {
                    up[i] = Math.Max(up[i], up[j] + 1);
                }
                if (arr[j] > arr[i])
                {
                    int tmp= Math.Max(down[j]+1, up[j] + 1);
                    down[i] = Math.Max(down[i], tmp);
                }
            }
            int max = Math.Max(up[i], down[i]);
            ans = Math.Max(ans, max);
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}