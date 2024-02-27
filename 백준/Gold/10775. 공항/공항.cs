#nullable disable
using System.Text;
public static class Program
{
    static int G, P;
    static int[] gate;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        G=ReadInt();
        P=ReadInt();
        gate=new int[G+1];
        for(int i=1;i<=G;i++)
            gate[i]=i;
        int ans=0;
        while(P-->0)
        {
            int target=ReadInt();
            int parent=find(target);
            if(parent==0)
                break;
            ans++;
            union(parent,parent-1);
        }
        sb.Append(ans);
        sw.WriteLine(sb);
        sw.Flush();
    }
    public static int find(int target)
    {
        if(target==gate[target])
        {
            return target;
        }
        else return gate[target]=find(gate[target]);
    }
    public static void union(int target, int parent)
    {
        target=find(target);
        parent=find(parent);
        if(target!=parent)
        {
            gate[target]=parent;
        }
    }
}