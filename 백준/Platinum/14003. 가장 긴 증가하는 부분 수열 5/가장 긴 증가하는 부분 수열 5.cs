#nullable disable
using System.Text;
public static class Program
{
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        int n = int.Parse(sr.ReadLine());
        int[] arr=sr.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int[] dp=new int[n];
        List<int> list=new List<int>();
        Stack<int> stack=new Stack<int>();
        list.Add(arr[0]);
        dp[0]=1;
        int idx=0;
        for(int i=1;i<n;i++)
        {
            if (list[list.Count-1] < arr[i])
            {
                list.Add(arr[i]);
                dp[i]=list.Count;
            }
            else
            {
                int left = 0;
                int right = list.Count;
                while (left<right)
                {
                    int mid = (left + right) / 2;
                    if (list[mid] < arr[i])
                    {
                        left = mid + 1;
                    }
                    else
                    {
                        right = mid;
                    }
                }
                list[left] = arr[i];
                dp[i]=left+1;
            }
            if(dp[i]>dp[idx])
            {
                idx=i;
            }
        }
        int now=arr[idx];
        stack.Push(now);
        for(int i=idx-1;i>=0;i--)
        {
            if(dp[i]==dp[idx]-1)
            {
                now=arr[i];
                idx=i;
                stack.Push(now);
            }
        }
        sb.Append(list.Count+"\n");
        while(stack.Count>0)
        {
            sb.Append(stack.Pop()+" ");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}