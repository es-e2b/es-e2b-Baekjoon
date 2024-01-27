#nullable disable
using System.Text;
public static class Program
{
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    private static int Read()
    {
        int c,n=Console.Read()&15;
        while((c=Console.Read())>32)
        {
            n=(n<<3)+(n<<1)+(c&15);
        }
        return n;
    }
    private static long ReadLong()
    {
        int c;
        long n=Console.Read()&15;
        while((c=Console.Read())>32)
        {
            n=(n<<3)+(n<<1)+(c&15);
        }
        return n;
    }
    public static void Main()
    {
        int n=Read();
        while(n-->0){
            int exp=0;
            int count=0;
            for(long l=ReadLong();l>0;l>>=1, exp++){
                if((l&1)==1){
                    sb.Append(exp+" ");
                    count++;
                }
            }
            if(count==1){
                sb.Clear();
                exp-=2;
                sb.Append(exp+" "+exp);
            }
            sw.WriteLine(sb);
            sb.Clear();
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}