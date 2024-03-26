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
        for(;pointerLeft<pointerRight;)
        {
            int sum=arr[pointerLeft]+arr[pointerRight];
            if(Math.Abs(sum)<ans)
            {
                ans=Math.Abs(sum);
                sb.Clear();
                sb.Append(arr[pointerLeft]+" "+arr[pointerRight]);
            }
            if(sum==0)
            {
                sb.Clear();
                sb.Append(arr[pointerLeft]+" "+arr[pointerRight]);
                break;
            }
            if(sum<0)
            {
                pointerLeft++;
                continue;
            }
            else
            {
                pointerRight--;
            }
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}