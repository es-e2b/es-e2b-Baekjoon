#nullable disable
using System.Text;
public static class Program
{
    static (int min, int idx, int start, int end)[] tree;
    static int exp, N,M;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        N=int.Parse(sr.ReadLine());
        // 입력된 수열의 개수에 따른 지수
        exp = 1 << (int)(Math.Ceiling(Math.Log2(N)));
        tree=new (int min, int idx, int start, int end)[exp<<1];
        int[] arr=sr.ReadLine().Split().Select(int.Parse).ToArray();
        for(int i=exp;i<exp+N;i++)
        {
            tree[i]=(arr[i-exp], i-exp+1, i-exp+1, i-exp+1);
        }
        for(int i=exp-1;i>0;i--)
        {
            int left=i*2;
            int right=i*2+1;
            tree[i].min=(tree[left].min==0||tree[right].min==0)?Math.Max(tree[left].min,tree[right].min)
                        :Math.Min(tree[left].min,tree[right].min);
            tree[i].idx=(tree[left].min==tree[i].min)?tree[left].idx:tree[right].idx;
            tree[i].start=(tree[left].start==0||tree[right].start==0)?Math.Max(tree[left].start,tree[right].start)
                        :Math.Min(tree[left].start,tree[right].start);
            tree[i].end=Math.Max(tree[left].end,tree[right].end);
        }
        M=int.Parse(sr.ReadLine());
        for(int i=0;i<M;i++)
        {
            string[] input2=sr.ReadLine().Split();
            if(int.Parse(input2[0])==1)
            {
                int index=exp-1+int.Parse(input2[1]);
                
                tree[index].min=int.Parse(input2[2]);
                for(int j=index/2;j>0;j/=2)
                {
                    int left2=j*2;
                    int right2=j*2+1;
                    tree[j].min=(tree[left2].min==0||tree[right2].min==0)?Math.Max(tree[left2].min,tree[right2].min)
                        :Math.Min(tree[left2].min,tree[right2].min);
                    tree[j].idx=(tree[left2].min==tree[j].min)?tree[left2].idx:tree[right2].idx;
                }
                continue;
            }
            int left=int.Parse(input2[1]);
            int right=int.Parse(input2[2]);
            sb.Append(min(1,left, right).idx+"\n");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
    private static (int min, int idx) min(int i, int left, int right)
    {
        if(tree[i].end<left||tree[i].start>right||i>exp+N)
        {
            return (1000000001, N);
        }
        if(left<=tree[i].start&&tree[i].end<=right)
        {
            return (tree[i].min==0)?(1000000001, N):(tree[i].min, tree[i].idx);
        }
        (int min, int idx) l=min(i*2,left,right);
        (int min, int idx) r=min(i*2+1,left,right);
        if(l.min<=r.min)
            return l;
        return r;
    }
}