#nullable disable
using System.Text;
public static class Program
{
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    public static void Main()
    {
        Reader reader=new();
        int K=reader.NextInt();
        for(int i=0;i<K;i++)
        {
            sb.AppendLine("Class "+(i+1));
            int N=reader.NextInt();
            int[] ints=new int[N];
            for(int j=0;j<N;j++)
            {
                ints[j]=reader.NextInt();
            }
            Array.Sort(ints);
            int largestGap=0;
            for(int j=0;j<N-1;j++)
            {
                largestGap=Math.Max(largestGap, Math.Abs(ints[j]-ints[j+1]));
            }
            sb.AppendLine("Max "+ints[N-1]+", Min "+ints[0]+", Largest gap "+largestGap);
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