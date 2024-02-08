#nullable disable
using System.Text;
public static class Program
{
    static int[] input;
    static (int negative, int zero, int start, int end)[] tree;
    static int exp, N,K;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        for(string s=sr.ReadLine();s!=null&&s.Length>0;s=sr.ReadLine())
        {
            input=s.Split().Select(int.Parse).ToArray();
            N=input[0]; K=input[1];
            // 입력된 수열의 개수에 따른 지수
            exp = 1 << (int)(Math.Ceiling(Math.Log2(N)));
            tree=new (int negative, int zero, int start, int end)[exp<<1];
            int[] ints=ReadIntArray();
            for(int i=exp;i<exp+N;i++)
            {
                tree[i]=((ints[i-exp]<0)?1:0, (ints[i-exp]==0)?0:1, i-exp+1, i-exp+1);
            }
            for(int i=exp+N;i<exp<<1;i++)
            {
                tree[i]=(0, 1, i-exp+1,i-exp+1);
            }
            for(int i=exp-1;i>0;i--)
            {
                int left=i*2;
                int right=i*2+1;
                tree[i].negative=tree[left].negative+tree[right].negative;
                tree[i].zero=tree[left].zero&tree[right].zero;
                tree[i].start=(tree[left].start==0||tree[right].start==0)?Math.Max(tree[left].start,tree[right].start)
                            :Math.Min(tree[left].start,tree[right].start);
                tree[i].end=Math.Max(tree[left].end,tree[right].end);
            }
            for(int i=0;i<K;i++)
            {
                string[] input2=sr.ReadLine().Split();
                if(input2[0].ToCharArray()[0]=='C')
                {
                    int index=exp-1+int.Parse(input2[1]);
                    tree[index].negative=(int.Parse(input2[2])<0)?1:0;
                    tree[index].zero=(int.Parse(input2[2])==0)?0:1;
                    for(int j=index/2;j>0;j/=2)
                    {
                        int left2=j*2;
                        int right2=j*2+1;
                        tree[j].negative=tree[left2].negative+tree[right2].negative;
                        tree[j].zero=tree[left2].zero&tree[right2].zero;
                    }
                    continue;
                }
                int left=int.Parse(input2[1]);
                int right=int.Parse(input2[2]);
                (int negative, int zero) ans=Ans(1,left,right);
                if(ans.zero==0)
                    sb.Append(0);
                else if(ans.negative%2==1)
                    sb.Append('-');
                else
                    sb.Append('+');
            }
            sb.AppendLine();
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
    private static (int negative, int zero) Ans(int idx, int left, int right)
    {
        if(tree[idx].end<left||tree[idx].start>right||idx>exp+N)
        {
            return (0, 1);
        }
        if(left<=tree[idx].start&&tree[idx].end<=right)
        {
            return (tree[idx].negative, tree[idx].zero);
        }
        (int negative, int zero) l=Ans(idx*2, left, right);
        (int negative, int zero) r=Ans(idx*2+1, left, right);
        return (l.negative+r.negative,l.zero&r.zero);
    }
}