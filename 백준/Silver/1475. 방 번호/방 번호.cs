#nullable disable
using System.Text;
public static class Program
{
    static int[] ints=new int[9];
    static StreamReader sr = new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb = new StringBuilder();
    static Func<int[]> ReadIntArray = () => Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
    static Func<int> ReadInt = () => int.Parse(sr.ReadLine());
    private static int Read()
    {
        int c,n=Console.Read()&15;
        while((c=Console.Read())>32)
        {
            n=(n<<3)+(n<<1)+(c&15);
        }
        return n;
    }
    public static void Main()
    {
        string input=sr.ReadLine();
        int max=0;
        foreach(char c in input)
        {
            int digit=c-'0';
            if(digit==9)
            {
                digit=6;
            }
            ints[digit]++;
            if(digit==6)
            {
                max=(ints[digit]%2==1)?Math.Max(max,ints[digit]/2+1):Math.Max(max,ints[digit]/2);
                continue;
            }
            max=Math.Max(max,ints[digit]);
        }
        sb.Append(max);
        sw.Write(sb);
        sw.Flush();
    }
}