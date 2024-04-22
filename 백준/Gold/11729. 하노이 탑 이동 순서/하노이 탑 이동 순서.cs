#nullable disable
using System.Text;
public static class Program
{
    static int N;
    static int ans=0;
    static Stack<int>[] stacks=new Stack<int>[4];
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    public static void Main()
    {
        N=ReadInt();
        for(int i=1;i<=3;i++)
        {
            stacks[i]=new Stack<int>();
        }
        for(int i=N;i>0;i--)
        {
            stacks[1].Push(i);
        }
        Move(1,3,N);
        Console.WriteLine(ans);
        sw.Write(sb);
        sw.Flush();
    }
    static void Move(int pre, int next, int value)
    {
        if(stacks[pre].Peek()!=value)
        {
            for(int i=1;i<=3;i++)
            {
                if(i==pre||i==next)continue;
                Move(pre,i,value-1);
                stacks[next].Push(stacks[pre].Pop());
                sb.Append(pre+" "+next+"\n");
                ans++;
                Move(i,next,value-1);
                return;
            }
        }
        stacks[next].Push(stacks[pre].Pop());
        sb.Append(pre+" "+next+"\n");
        ans++;
    }
}