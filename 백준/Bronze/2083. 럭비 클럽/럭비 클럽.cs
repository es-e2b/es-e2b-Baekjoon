#nullable disable
using System.Text;
public static class Program
{
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    public static void Main()
    {
        string[] inputs=sr.ReadLine().Split();
        while(inputs[0]!="#"&&inputs[1]!="0"&&inputs[2]!="0")
        {
            int a=int.Parse(inputs[1]);
            int b=int.Parse(inputs[2]);
            sb.Append(inputs[0]).Append(" ");
            if(a>17 || b>=80)
                sb.AppendLine("Senior");
            else
                sb.AppendLine("Junior");
            inputs=sr.ReadLine().Split();
        }
        sw.Write(sb);
        sw.Flush();
    }
}