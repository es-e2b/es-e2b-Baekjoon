#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        int N = int.Parse(sr.ReadLine());
        long[] xs = new long[N];
        long[] ys = new long[N];

        for (int i = 0; i < N; i++)
        {
            var parts = sr.ReadLine().Split();
            xs[i] = long.Parse(parts[0]);
            ys[i] = long.Parse(parts[1]);
        }

        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++)
        {
            int j = (i + 1) % N;
            sum1 += xs[i] * ys[j];
            sum2 += ys[i] * xs[j];
        }

        double area = Math.Abs(sum1 - sum2) / 2.0;

        sb.Append(area.ToString("F1"));
        
        sw.Write(sb);
        sw.Flush();
    }
}