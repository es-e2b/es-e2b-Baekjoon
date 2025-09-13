#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        long T=long.Parse(sr.ReadLine());
        Dictionary<long, long> dictA = new Dictionary<long, long>();
        Dictionary<long, long> dictB = new Dictionary<long, long>();
        long count = long.Parse(sr.ReadLine());
        long[] longs = new long[count];
        long[] array = Array.ConvertAll(sr.ReadLine().Split(), long.Parse);
        long idx = 0;
        for (int i = 0; i < count; i++)
        {
            long input = array[i];
            for (int j = 0; j < idx; j++)
            {
                longs[j] += input;
                dictA[longs[j]] = dictA.ContainsKey(longs[j]) ? dictA[longs[j]] + 1 : 1;
            }

            longs[idx] = input;
            dictA[longs[idx]] = dictA.ContainsKey(longs[idx]) ? dictA[longs[idx]] + 1 : 1;
            idx++;
        }
        
        count = long.Parse(sr.ReadLine());
        longs = new long[count];
        array = Array.ConvertAll(sr.ReadLine().Split(), long.Parse);
        idx = 0;
        for (int i = 0; i < count; i++)
        {
            long input = array[i];
            for (int j = 0; j < idx; j++)
            {
                longs[j] += input;
                dictB[longs[j]] = dictB.ContainsKey(longs[j]) ? dictB[longs[j]] + 1 : 1;
            }

            longs[idx] = input;
            dictB[longs[idx]] = dictB.ContainsKey(longs[idx]) ? dictB[longs[idx]] + 1 : 1;
            idx++;
        }
        
        count = 0;
        foreach (long elementA in dictA.Keys)
        {
            if(!dictB.TryGetValue(T - elementA, out long val))
            {
                val = 0;
            }
            count += val * dictA[elementA];
        }

        sb.Append(count);
        
        sw.Write(sb);
        sw.Flush();
    }
}