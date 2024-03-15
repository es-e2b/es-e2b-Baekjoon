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
        int N=ReadInt();
        HashSet<int> set=new HashSet<int>(N);
        int[] array=ReadIntArray();
        for(int i=0;i<N;i++)
        {
            set.Add(array[i]);
        }
        int M=ReadInt();
        int[] array2=ReadIntArray();
        for(int i=0;i<M;i++)
        {
            sb.Append(set.Contains(array2[i]) ? "1" : "0");
            sb.Append(" ");
        }

        sw.WriteLine(sb);
        sw.Flush();
    }
}