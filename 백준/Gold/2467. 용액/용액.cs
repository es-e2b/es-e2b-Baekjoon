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
        int N=ReadInt();
        int[] arr=ReadIntArray();
        Array.Sort(arr);
        int pointerLeft=0;
        int pointerRight=N-1;
        int ans=2_000_000_000;
        int left=0;
        int right=0;
        for(;pointerLeft<pointerRight;)
        {
            int sum=arr[pointerLeft]+arr[pointerRight];
            int abs=Math.Abs(sum);
            if(abs<ans)
            {
                left=arr[pointerLeft];
                right=arr[pointerRight];
                ans=abs;
            }
            if(sum==0)
            {
                break;
            }
            if(sum<0)
            {
                pointerLeft++;
            }
            else
            {
                pointerRight--;
            }
        }
        sb.Append(left+" "+right);
        sw.WriteLine(sb);
        sw.Flush();
    }
}