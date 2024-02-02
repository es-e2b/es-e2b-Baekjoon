#nullable disable
using System.Text;
public static class Program
{
    static int count=0, N;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
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
    public static void Main()
    {
        N=Read();
        if(N>1022)
        {
            sb.Append(-1);
        }
        else if(N==0)
            sb.Append(0);
        else if(N==1022)
            sb.Append(9876543210);
        else
        {
            int i;
            for(i=1;count<N;)
            {
                string s=i.ToString();
                bool isMinus=true;
                int idx=0;
                for(int j=0;j<s.Length-1;j++)
                {
                    if(s[j]<=s[j+1])
                    {
                        isMinus=false;
                        idx=s.Length-j-1;
                        break;
                    }
                } 
                if(isMinus)
                {
                    count++;
                    i++;
                }
                else
                {
                    i+=(int)Math.Pow(10,idx-1);
                }
            }
            sb.Append(i-1);
        }
        sw.WriteLine(sb);
        sw.Flush();
    }
}