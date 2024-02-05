#nullable disable
using System.Text;
public static class Program
{
    static (int odd, int even, int start, int end)[] tree;
    static int exp, N,M;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    public static void Main()
    {
        N=int.Parse(sr.ReadLine());
        // 입력된 수열의 개수에 따른 지수
        exp = 1 << (int)(Math.Ceiling(Math.Log2(N)));
        tree=new (int odd, int even, int start, int end)[exp<<1];
        int[] arr=sr.ReadLine().Split().Select(int.Parse).ToArray();
        for(int i=exp;i<exp+N;i++)
        {
            if(arr[i-exp]%2==1)
                tree[i]=(1, 0, i-exp+1, i-exp+1);
            else
                tree[i]=(0, 1, i-exp+1, i-exp+1);
        }
        for(int i=exp-1;i>0;i--)
        {
            int left=i*2;
            int right=i*2+1;
            tree[i].odd=tree[left].odd+tree[right].odd;
            tree[i].even=tree[left].even+tree[right].even;
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
                int num=int.Parse(input2[2])%2;
                if(num==1)
                {
                    tree[index].odd=1;
                    tree[index].even=0;
                }
                else
                {
                    tree[index].odd=0;
                    tree[index].even=1;
                }   
                for(int j=index/2;j>0;j/=2)
                {
                    int left2=j*2;
                    int right2=j*2+1;
                    tree[j].odd=tree[left2].odd+tree[right2].odd;
                    tree[j].even=tree[left2].even+tree[right2].even;
                }
                continue;
            }
            int left=int.Parse(input2[1]);
            int right=int.Parse(input2[2]);
            if(int.Parse(input2[0])==2)
                sb.Append(even(1,left, right).even+"\n");
            else
                sb.Append(even(1,left, right).odd+"\n");
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
    private static (int odd, int even) even(int i, int left, int right)
    {
        if(tree[i].end<left||tree[i].start>right||i>exp+N)
        {
            return (0, 0);
        }
        if(left<=tree[i].start&&tree[i].end<=right)
        {
            return (tree[i].odd, tree[i].even);
        }
        (int odd, int even) l=even(i*2, left, right);
        (int odd, int even) r=even(i*2+1, left, right);
        return (l.odd+r.odd, l.even+r.even);
    }
}