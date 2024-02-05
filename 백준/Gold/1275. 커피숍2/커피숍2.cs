#nullable disable
using System.Text;
public static class Program
{
    static (long sum, int start, int end)[] tree;
    static int exp, N,M;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        string[] input=sr.ReadLine().Split();
        N=int.Parse(input[0]);
        M=int.Parse(input[1]);
        long[] arr=sr.ReadLine().Split().Select(long.Parse).ToArray();
        // 입력된 수열의 개수에 따른 지수
        exp = 1 << (int)(Math.Ceiling(Math.Log2(N)));
        tree=new (long sum, int start, int end)[exp<<1];
        for(int i=exp;i<exp+N;i++)
        {
            tree[i]=(arr[i-exp], i-exp+1, i-exp+1);
        }
        for(int i=exp-1;i>0;i--)
        {
            int left=i*2;
            int right=i*2+1;
            tree[i].sum=tree[left].sum+tree[right].sum;
            tree[i].start=(tree[left].start==0||tree[right].start==0)?Math.Max(tree[left].start,tree[right].start)
                        :Math.Min(tree[left].start,tree[right].start);
            tree[i].end=Math.Max(tree[left].end,tree[right].end);
        }
        for(int i=0;i<M;i++)
        {
            string[] input2=sr.ReadLine().Split();
            int left=int.Parse(input2[0]);
            int right=int.Parse(input2[1]);
            if(left>right)
            {
                int tmp=left;
                left=right;
                right=tmp;
            }
            sb.Append(sum(1,left, right)+"\n");
            int index=exp-1+int.Parse(input2[2]);
            long gap=long.Parse(input2[3])-tree[index].sum;
            for(int j=index;j>0;j/=2)
            {
                tree[j].sum+=gap;
            }
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
    private static long sum(int idx, int left, int right)
    {
        if(tree[idx].end<left||tree[idx].start>right||idx>exp+N)
        {
            return 0;
        }
        if(left<=tree[idx].start&&tree[idx].end<=right)
        {
            return tree[idx].sum;
        }
        return sum(idx*2,left,right)+sum(idx*2+1,left,right);
    }
}