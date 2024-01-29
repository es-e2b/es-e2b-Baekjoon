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
        int[] lis = new int[n];
        Array.Fill(lis, 1);
        int[] index = new int[n];
        Array.Fill(index, -1);
        int last = 0;
        int max = 1;
        for(int i=1;i<n;i++)
        {
            for(int j = 0; j < i; j++)
            {
                if (arr[j] < arr[i])
                {
                    lis[i] = Math.Max(lis[i], lis[j]+1);
                    if (max < lis[i])
                    {
                        max = lis[i];
                        last = i;
                    }
                    if (lis[j] == lis[i]-1)
                    {
                        index[i] = j;
                    }
                }
            }
        }
        Stack<int> stack = new Stack<int>();
        while (last>=0)
        {
            stack.Push(arr[last]);
            last = index[last];
        }
        sb.AppendLine(max.ToString());
        while(stack.Count > 0)
        {
            sb.Append(stack.Pop()+" ");
        }

        sw.WriteLine(sb);
        sw.Flush();
    }
}