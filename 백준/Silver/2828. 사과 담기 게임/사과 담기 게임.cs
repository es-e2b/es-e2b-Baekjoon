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
        int N=reader.NextInt(), M=reader.NextInt();
        int left=1;
        int right=M;
        int ans=0;
        int j=reader.NextInt();
        while(j-->0)
        {
            int now=reader.NextInt();
            if(now>N)continue;
            if(now<left)
            {
                int gap=left-now;
                ans+=gap;
                right-=gap;
                left-=gap;
                continue;
            }
            if(now>right)
            {
                int gap=now-right;
                ans+=gap;
                left+=gap;
                right+=gap;
                continue;
            }
        }
        sb.Append(ans);
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