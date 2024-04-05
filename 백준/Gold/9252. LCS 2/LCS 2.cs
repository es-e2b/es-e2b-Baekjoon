#nullable disable
using System.Text;
public static class Program
{
    static string s1;
    static string s2;
    static int[,] dp;
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());

    public static void Main()
    {
        s1=sr.ReadLine();
        s2=sr.ReadLine();
        dp=new int[s1.Length, s2.Length];
        for(int i=0;i<s1.Length;i++)
        {
            for(int j=0;j<s2.Length;j++)
            {
                if(s1[i]==s2[j])
                {
                    if(i>0&&j>0)
                    {
                        dp[i,j]=dp[i-1,j-1]+1;
                    }
                    else
                    {
                        dp[i,j]=1;
                    }
                }
                else
                {
					if(i>0&&j>0)
						dp[i,j]=Math.Max(dp[i-1,j], dp[i,j-1]);
					else if(i>0)
						dp[i,j]=dp[i-1,j];
					else if(j>0)
						dp[i,j]=dp[i,j-1];
					else
						dp[i,j]=0;
                }
            }
        }
        string ans="";
        Stack<char> chars=new Stack<char>();
        for(int i=s1.Length-1, j=s2.Length-1;i>=0||j>=0;)
        {
            if(i==0&&j==0)
            {
                if(s1[i]==s2[j])
                    chars.Push(s1[0]);
                break;
            }
            if(i==0)
            {
                if(s1[i]==s2[j])
                {
                    chars.Push(s2[j]);
                    break;
                }
                j--;
                continue;

            }
            if(j==0)
            {
                if(s1[i]==s2[j])
                {
                    chars.Push(s1[i]);
                    break;
                }
                i--;
                continue;
            }
            if(s1[i]==s2[j])
            {
                chars.Push(s1[i]);
                i--;
                j--;
                continue;
            }
            if(dp[i,j]==dp[i-1,j])
            {
                i--;
                continue;
            }
            j--;
            continue;
        }
        while(chars.Count>0)
        {
            ans+=chars.Pop();
        }
        sb.AppendLine(dp[s1.Length-1,s2.Length-1].ToString());
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}