#nullable disable
using System.Text;
public static class Program
{
    static int N;
    static int[] operators;
    static int[] A;
    static int max=int.MinValue,min=int.MaxValue;
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    // static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    public static void Main()
    {
        Reader reader=new();
        N=reader.NextInt();
        A=new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=reader.NextInt();
        }
        operators=new int[4];
        for(int i=0;i<4;i++)
        {
            operators[i]=reader.NextInt();
        }
        for(int i=0;i<4;i++)
        {
            if(operators[i]==0)
            {
                continue;
            }
            operators[i]-=1;
            CalculateAnswer(1, A[0], i);
            operators[i]+=1;
        }
        sb.Append(max).AppendLine().Append(min);
        sw.Write(sb);
        sw.Flush();
    }
    static void CalculateAnswer(int index, int sum, int oper)
    {
        switch(oper)
        {
            case 0:
            sum+=A[index];
            break;
            case 1:
            sum-=A[index];
            break;
            case 2:
            sum*=A[index];
            break;
            case 3:
            sum/=A[index];
            break;
        }
        if(index==N-1)
        {
            max=max>sum?max:sum;
            min=min<sum?min:sum;
            return;
        }
        for(int i=0;i<4;i++)
        {
            if(operators[i]==0)
            {
                continue;
            }
            operators[i]-=1;
            CalculateAnswer(index+1, sum, i);
            operators[i]+=1;
        }
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