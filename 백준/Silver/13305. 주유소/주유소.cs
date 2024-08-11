#nullable disable
using System.Numerics;
using System.Text;
public static class Program
{
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    public static void Main()
    {
        Reader reader=new();
        BigInteger price=0;
        BigInteger distance=0;
        int now=0;
        int next=1;
        int N=reader.NextInt();
        int[] distances=new int[N];
        for(int i=1;i<N;i++)
        {
            distances[i]=reader.NextInt();
        }
        int[] prices=new int[N];
        for(int i=0;i<N;i++)
        {
            prices[i]=reader.NextInt();
        }
        while(now<N-1)
        {
            distance+=distances[next];
            if(prices[next]<prices[now] || next==N-1)
            {
                price+=distance*prices[now];
                distance=0;
                now=next;
            }
            next++;
        }
        sb.Append(price);
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