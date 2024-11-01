using System;
using System.Text;
namespace TEST
{
    class Program
    {
        static char[,] star = new char[3000, 3000];
        static void makestar(int n)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    star[i, j] = ' ';
                }
            }
        }
        static void fillstar(int n, int x, int y)
        {
            if (n == 1)
            {
                star[x, y] = '*';
                return;
            }
            int div = n / 3;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (i == 1 && j == 1)
                    {
                        continue;
                    }

                    fillstar(div, x + (div * i), y + (div * j));
                }
            }
            return;
        }
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            StringBuilder builder = new StringBuilder();
            makestar(n);
            fillstar(n, 0, 0);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    builder.Append(star[i, j]);
                }
                builder.Append("\n");
            }
            Console.WriteLine(builder.ToString());
        }
    }
}