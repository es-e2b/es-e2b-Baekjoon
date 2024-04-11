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
        int[] alph=new int[26];
        string input=sr.ReadLine();
        for(int i=0;i<input.Length;i++)
        {
            alph[input[i]-'a']++;
        }
        int ans=alph[0]+alph['e'-'a']+alph['i'-'a']+alph['o'-'a']+alph['u'-'a'];
        sb.Append(ans);
        sw.Write(sb);
        sw.Flush();
    }
}