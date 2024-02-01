#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        string s=sr.ReadLine();
        string explode=sr.ReadLine();
        List<char> list=new List<char>();
        for(int i=0;i<s.Length;i++)
        {
            list.Add(s[i]);
            if(s[i]==explode[explode.Length-1]&&list.Count>=explode.Length) // 문자열의 현재 문자와 폭발 문자열의 마지막 글자 비교
            {
                bool isBomb=true;
                for(int j=explode.Length;j>0;j--)
                {
                    if(explode[j-1]!=list[list.Count-1-explode.Length+j])
                    {
                        isBomb=false;
                        break;
                    }
                }
                if(isBomb)
                {
                    for(int j=0;j<explode.Length;j++)
                        list.RemoveAt(list.Count-1);
                }
            }
        }
        for(int i=0;i<list.Count;i++)
            sb.Append(list[i]);
        if(sb.Length==0)
        {
            sb.Append("FRULA");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}