#nullable disable
using System.Text;
public static class Program
{
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    public static void Main()
    {
        Reader reader=new();
        int N=reader.NextInt(), M=reader.NextInt();
        int[,] A=new int[N,M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                A[i,j]=reader.NextInt();
            }
        }
        M=reader.NextInt(); int K=reader.NextInt();
        int[,] B=new int[M,K];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<K;j++)
            {
                B[i,j]=reader.NextInt();
            }
        }
        int[,] ans=new int[N,K];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < K; j++)
            {
                ans[i,j]=0;
                for(int k=0;k<M;k++)
                {
                    ans[i,j]+=A[i,k]*B[k,j];
                }
                sb.Append(ans[i,j]).Append(' ');
            }
            sb.AppendLine();
        }
        sw.Write(sb);
        sw.Flush();
    }
    class Reader
    {
        StreamReader reader;

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