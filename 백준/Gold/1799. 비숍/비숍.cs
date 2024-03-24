#nullable disable
using System.Text;
public static class Program
{
    static int n, ansOdd = 0, ansEven = 0;
    static int[] chess;
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());

    public static void Main()
    {
        n = ReadInt();
        chess = new int[2*n];
        for (int i = 0; i < n; i++)
        {
            int[] input = ReadIntArray();
            for (int j = 0; j < n; j++)
            {
                if (input[j] == 0)
                {
                    if(i+j+1<=n)
                    {
                        chess[i+j+1]|=1<<i;
                    }
                    else
                    {
                        chess[i+j+1]|=1<<(n-j-1);
                    }
                }
            }
        }

        odd(0, 1);
        even(0, 2);

        sb.Append(ansOdd+ansEven);
        sw.WriteLine(sb);
        sw.Flush();
    }

    public static void odd(int current, int row)
    {
        if (row >= 2*n)
        {
            ansOdd=Math.Max(current, ansOdd);
            return;
        }

        int max=(row<=n)?row:2*n-row;
        for (int col = 1; col <= max; col++)
        {
            if (placable(row, col))
            {
                int[] tmp=new int[2*n];
                for(int i=1;i<2*n;i++)
                {
                    tmp[i]=chess[i];
                }
                place(row, col);
                odd(current + 1, row + 2);
                chess=tmp;
                continue;
            }
            odd(current, row+2);
        }
    }

    public static void even(int current, int row)
    {
        if (row >= 2*n)
        {
            ansEven=Math.Max(current, ansEven);
            return;
        }

        int max=(row<=n)?row:2*n-row;
        for (int col = 1; col <= max; col++)
        {
            if (placable(row, col))
            {
                int[] tmp=new int[2*n];
                for(int i=1;i<2*n;i++)
                {
                    tmp[i]=chess[i];
                }
                place(row, col);
                even(current + 1, row + 2);
                chess=tmp;
                continue;
            }
            even(current, row+2);
        }
    }

    public static void place(int row, int col)
    {
        if(row>n)
        {
            row=2*n-row;
        }
        for(int i=row, j=2*n-row, tmp=col-1; i>0 && j<2*n && tmp>=0;i-=2, j+=2, tmp--)
        {
            chess[i]|=1<<tmp;
            chess[j]|=1<<tmp;
        }
        for(int i=row, j=2*n-row, tmp=col-1; i<=n && j>=n;i+=2, j-=2, tmp++)
        {
            chess[i]|=1<<tmp;
            chess[j]|=1<<tmp;
        }
    }

    public static bool placable(int row, int col)
    {
        return (chess[row] & (1 << col-1)) == 0;
    }
    public static void PrintChess()
    {
        for(int i=1;i<2*n;i++)
        {
            Console.WriteLine(chess[i]+":"+i);
        }
        Console.WriteLine();
    }
}