#nullable disable
using System.Text;
public static class Program
{
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    // static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    public static void Main()
    {
        Reader reader=new();
        int N=reader.NextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++)
            A[i]=reader.NextInt();
        int[] B=new int[N];
        for(int i=0;i<N;i++)
            B[i]=i;
        // Array.Sort(B, (i, j) => A[i].CompareTo(A[j]));
        int[] P=new int[N];
        int[] ans=new int[N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(P[j]==0||P[j]>A[i])
                {
                    for(int k=N-1;k>j;k--)
                    {
                        P[k]=P[k-1];
                        ans[k]=ans[k-1];
                    }
                    P[j]=A[i];
                    ans[j]=i;
                    break;
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            P[ans[i]]=i;
        }
        for(int i=0;i<N;i++)
        {
            sb.Append(P[i]);
            if(i!=N-1)
                sb.Append(' ');
        }
        sw.Write(sb);
        sw.Flush();
    }
    class Reader
    {
        readonly StreamReader reader;
        public Reader()
        {
            BufferedStream stream = new(Console.OpenStandardInput());
            reader = new(stream);
        }
        public int NextInt()
        {
            bool negative = false;
            bool reading = false;
            int value = 0;
            while (true)
            {
                int c = reader.Read();
                if (reading == false && c == '-')
                {
                    negative = true;
                    reading = true;
                    continue;
                }
                if ('0' <= c && c <= '9')
                {
                    value = value * 10 + (c - '0');
                    reading = true;
                    continue;
                }
                if (reading == true)
                    break;
            }
            return negative ? -value : value;
        }
        public long NextLong()
        {
            bool negative = false;
            bool reading = false;
            long value = 0;
            while (true)
            {
                int c = reader.Read();
                if (reading == false && c == '-')
                {
                    negative = true;
                    reading = true;
                    continue;
                }
                if ('0' <= c && c <= '9')
                {
                    value = value * 10 + (c - '0');
                    reading = true;
                    continue;
                }
                if (reading == true)
                    break;
            }
            return negative ? -value : value;
        }
    }
}