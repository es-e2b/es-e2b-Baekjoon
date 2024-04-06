#nullable disable
using System.Text;
public static class Program
{
    static int[,] arr;
    static readonly Dictionary<(int start, int pre, int now), int> map=new Dictionary<(int start, int pre, int now), int>();
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    public static void Main()
    {
        int n=ReadInt();
        arr=new int[n,3];
        for(int i=0;i<n;i++)
        {
            int[] now=ReadIntArray();
            arr[i,0]=now[0];
            arr[i,1]=now[1];
            arr[i,2]=now[2];
        }
        int ans=int.MaxValue;
        for(int i=0;i<3;i++)
            ans=Math.Min(ans,RGB(i,i,n-2)+arr[n-1,i]);
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
    public static int RGB(int start, int pre, int now)
    {
        if(map.ContainsKey((start,pre,now)))return map[(start,pre,now)];
        if(now==0)
        {
            int min=int.MaxValue;
            for(int i=0;i<3;i++)
            {
                if(i==start||i==pre)continue;
                min=Math.Min(min,arr[0,i]);
            }
            return min;
        }
        int min2=int.MaxValue;
        for(int i=0;i<3;i++)
        {
            if(i==pre)continue;
            min2=Math.Min(min2,RGB(start,i,now-1)+arr[now,i]);
        }
        map.Add((start, pre, now),min2);
        return min2;
    }
}