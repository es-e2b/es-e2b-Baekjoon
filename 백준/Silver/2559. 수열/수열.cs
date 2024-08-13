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
        int N=reader.NextInt(), K=reader.NextInt();
        int[] ints=new int[N];
        for(int i=0;i<N;i++)
        {
            ints[i]=reader.NextInt();
        }
        int max=0;
        for(int i=0;i<K;i++)
        {
            max+=ints[i];
        }
        int now=max;
        for(int i=0,j=K;j<N;i++,j++)
        {
            now=now-ints[i]+ints[j];
            max=Math.Max(now,max);
        }
        sb.Append(max);
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