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
        int[] input=ReadIntArray();
        int N=input[0]*input[1];
        int[] input2=ReadIntArray();
        for(int i=0;i<5;i++)
            sb.Append(input2[i]-N+" ");
        sw.WriteLine(sb);
        sw.Flush();
    }
}