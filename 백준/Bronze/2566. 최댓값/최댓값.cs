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
        int max=0;
        int row=0;
        int col=0;
        for(int i=0;i<9;i++)
        {
            int[] input=ReadIntArray();
            for(int j=0;j<9;j++)
            {
                if(input[j]>=max)
                {
                    max=input[j];
                    row=i+1;
                    col=j+1;
                }
            }
        }
        sb.AppendLine(max.ToString());
        sb.Append(row+" "+col);
        sw.Write(sb);
        sw.Flush();
    }
}