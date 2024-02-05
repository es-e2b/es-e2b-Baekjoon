#nullable disable
using System.Text;
public static class Program
{
    static (long multi, int start, int end)[] tree;
    static int exp, N,M,K;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        string[] input=sr.ReadLine().Split();
        N=int.Parse(input[0]);
        M=int.Parse(input[1]);
        K=int.Parse(input[2]);
        // 입력된 수열의 개수에 따른 지수
        exp = 1 << (int)(Math.Ceiling(Math.Log2(N)));
        tree=new (long sum, int start, int end)[exp<<1];
        for(int i=exp;i<exp+N;i++)
        {
            tree[i]=(long.Parse(sr.ReadLine()), i-exp+1, i-exp+1);
        }
        for(int i=exp+N;i<exp<<1;i++)
        {
            tree[i]=(1,i-exp+1,i-exp+1);
        }
        for(int i=exp-1;i>0;i--)
        {
            int left=i*2;
            int right=i*2+1;
            tree[i].multi=tree[left].multi*tree[right].multi%1_000_000_007;
            tree[i].start=(tree[left].start==0||tree[right].start==0)?Math.Max(tree[left].start,tree[right].start)
                        :Math.Min(tree[left].start,tree[right].start);
            tree[i].end=Math.Max(tree[left].end,tree[right].end);
        }
        for(int i=0;i<M+K;i++)
        {
            string[] input2=sr.ReadLine().Split();
            if(int.Parse(input2[0])==1)
            {
                int index=exp-1+int.Parse(input2[1]);
                tree[index].multi=long.Parse(input2[2]);
                for(int j=index/2;j>0;j/=2)
                {
                    int left2=j*2;
                    int right2=j*2+1;
                    tree[j].multi=tree[left2].multi*tree[right2].multi%1_000_000_007;
                }
                continue;
            }
            int left=int.Parse(input2[1]);
            int right=int.Parse(input2[2]);
            sb.Append(multiply(1,left, right)+"\n");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
    private static long multiply(int idx, int left, int right)
    {
        if(tree[idx].end<left||tree[idx].start>right||idx>exp+N)
        {
            return 1;
        }
        if(left<=tree[idx].start&&tree[idx].end<=right)
        {
            return tree[idx].multi;
        }
        return multiply(idx*2,left,right)*multiply(idx*2+1,left,right)%1_000_000_007;
    }
}