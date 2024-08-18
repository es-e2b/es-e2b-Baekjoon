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
        sb.Append(reader.NextInt()%2==0?"SK":"CY");
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