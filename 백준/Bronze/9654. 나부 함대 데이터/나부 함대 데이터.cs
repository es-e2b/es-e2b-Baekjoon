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
        sb.AppendLine("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE");
        sb.AppendLine("N2 Bomber      Heavy Fighter  Limited    21        ");
        sb.AppendLine("J-Type 327     Light Combat   Unlimited  1         ");
        sb.AppendLine("NX Cruiser     Medium Fighter Limited    18        ");
        sb.AppendLine("N1 Starfighter Medium Fighter Unlimited  25        ");
        sb.AppendLine("Royal Cruiser  Light Combat   Limited    4         ");
        sw.WriteLine(sb);
        sw.Flush();
    }
}