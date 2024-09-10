#nullable disable
using System.Text;
public static class Program
{
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    public static void Main()
    {
        // Reader reader=new();
        string input=sr.ReadLine();
        int index=0;
        string ans="UCPC";
        for(int i=0;i<input.Length;i++)
        {
            if(input[i]==ans[index])
            {
                index++;
                if(index>=4)break;
            }
        }
        if(index>=4)
        {
            sb.Append("I love UCPC");
        }
        else
        {
            sb.Append("I hate UCPC");
        }
        sw.Write(sb);
        sw.Flush();
    }
}