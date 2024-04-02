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
        int[] input=ReadIntArray();
        int N=input[0];
        int S=input[1];
        int[] arr=ReadIntArray();
        int sum=arr[0];
        int len=1;
        int ans=int.MaxValue;
        for(int left=0,right=0;left<N&&right<N;)
        {
            if(sum>=S)
            {
                len=right-left+1;
                ans=Math.Min(ans,len);
                sum-=arr[left];
                left++;
            }
            else
            {
                right++;
                if(right<N)
                {
                    sum+=arr[right];
                }
            }
        }
        if(ans==int.MaxValue)
        {
            ans=0;
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
}