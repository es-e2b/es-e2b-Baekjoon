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
        int[] arr=ReadIntArray();
        if(arr[0]==arr[1]&&arr[1]==arr[2])
        {
            sb.Append(10000+arr[0]*1000);
        }
        else if(arr[0]!=arr[1]&&arr[1]!=arr[2]&&arr[2]!=arr[0])
        {
            int max=0;
            max=Math.Max(max,arr[0]);
            max=Math.Max(max,arr[1]);
            max=Math.Max(max,arr[2]);
            sb.Append(max*100);
        }
        else
        {
            for(int i=0;i<3;i++)
            {
                if(arr[i]==arr[(i+1)%3])
                {
                    sb.Append(arr[i]*100+1000);
                    break;
                }
            }
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}