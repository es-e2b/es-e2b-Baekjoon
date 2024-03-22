#nullable disable
using System.Text;
public static class Program
{
    static int[] Inorder;
    static int[] Postorder;
    static int[] IdxRoot;
    static StreamReader sr=new StreamReader(Console.OpenStandardInput(), bufferSize: 65536);
    static StreamWriter sw=new StreamWriter(Console.OpenStandardOutput(), bufferSize: 65536);
    static StringBuilder sb=new StringBuilder();
    static Func<int[]> ReadIntArray=()=>Array.ConvertAll(sr.ReadLine().Split(),int.Parse);
    static Func<int> ReadInt=()=>int.Parse(sr.ReadLine());
    public static void Main()
    {
        int len=ReadInt();
        Inorder=ReadIntArray();
        Postorder=ReadIntArray();
        IdxRoot=new int[100001];
        for(int i=0;i<len;i++)
        {
            IdxRoot[Inorder[i]]=i;
        }
        printAns((0, len-1), (0, len-1));
        sw.WriteLine(sb);
        sw.Flush();
    }
    public static void printAns((int startIdx, int endIdx) inorder, (int startIdx, int endIdx) postorder)
    {
        if(inorder.endIdx<inorder.startIdx&&postorder.endIdx<postorder.startIdx)
            return;
        int root=Postorder[postorder.endIdx];
        int idx=IdxRoot[root];
        int lenLeft=idx-inorder.startIdx;
        int lenRight=inorder.endIdx-idx;
        sb.Append(root+" ");
        printAns((inorder.startIdx,inorder.startIdx+lenLeft-1), (postorder.startIdx, postorder.startIdx+lenLeft-1));
        printAns((inorder.endIdx-lenRight+1, inorder.endIdx), (postorder.endIdx-lenRight, postorder.endIdx-1));
    }
}