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
        List<int> list=new List<int>();
        list.Add(arr[0]);
        for(int i=1;i<n;i++)
        {
            if (list[list.Count-1] < arr[i])
            {
                list.Add(arr[i]);
                continue;
            }
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
        }
        sb.Append(list.Count);
        sw.WriteLine(sb);
        sw.Flush();
    }
}