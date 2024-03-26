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
        int N=ReadInt();
        int[] card=ReadIntArray();
        int[] idx=new int[1_000_001];
        Array.Fill(idx, -1);
        int[] point=new int[N];
        int max=card.Max();
        for(int i=0;i<N;i++)
        {
            idx[card[i]]=i;
        }
        for(int i=0;i<N;i++)
        {
            for(int j=card[i];j<=max;j+=card[i])
            {
                if(idx[j]>=0)
                {
                    point[idx[j]]--;
                    point[i]++;
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            sb.Append(point[i]+" ");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}