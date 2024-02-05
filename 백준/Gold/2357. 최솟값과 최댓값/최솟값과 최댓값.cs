#nullable disable
using System.Text;
public static class Program
{
    static (int max, int min, int start, int end)[] tree;
    static int exp, N,M;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        string[] input=sr.ReadLine().Split();
        N=int.Parse(input[0]);
        M=int.Parse(input[1]);
        // 입력된 수열의 개수에 따른 지수
        exp = 1 << (int)(Math.Ceiling(Math.Log2(N)));
        tree=new (int max, int min, int start, int end)[exp<<1];
        for(int i=exp;i<exp+N;i++)
        {
            int n=int.Parse(sr.ReadLine());
            tree[i]=(n, n, i-exp+1, i-exp+1);
        }
        for(int i=exp-1;i>0;i--)
        {
            int left=i*2;
            int right=i*2+1;
            tree[i].max=Math.Max(tree[left].max, tree[right].max);
            tree[i].min=(tree[left].min==0||tree[right].min==0)?Math.Max(tree[left].min,tree[right].min)
                        :Math.Min(tree[left].min,tree[right].min);
            tree[i].start=(tree[left].start==0||tree[right].start==0)?Math.Max(tree[left].start,tree[right].start)
                        :Math.Min(tree[left].start,tree[right].start);
            tree[i].end=Math.Max(tree[left].end,tree[right].end);
        }
        for(int i=0;i<M;i++)
        {
            string[] input2=sr.ReadLine().Split();
            int left=int.Parse(input2[0]);
            int right=int.Parse(input2[1]);
            sb.Append(min(1,left, right)+" "+max(1,left, right)+"\n");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
    private static int max(int idx, int left, int right)
    {
        if(tree[idx].end<left||tree[idx].start>right||idx>exp+N)
        {
            return 0;
        }
        if(left<=tree[idx].start&&tree[idx].end<=right)
        {
            return tree[idx].max;
        }
        return Math.Max(max(idx*2,left,right),max(idx*2+1,left,right));
    }
    private static int min(int idx, int left, int right)
    {
        if(tree[idx].end<left||tree[idx].start>right||idx>exp+N)
        {
            return 1000000000;
        }
        if(left<=tree[idx].start&&tree[idx].end<=right)
        {
            return (tree[idx].min==0)?1000000000:tree[idx].min;
        }
        return Math.Min(min(idx*2,left,right),min(idx*2+1,left,right));
    }
}