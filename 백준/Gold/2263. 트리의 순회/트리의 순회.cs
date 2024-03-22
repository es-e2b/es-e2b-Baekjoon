#nullable disable
using System.Text;
public static class Program
{
    static int[] Inorder;
    static int[] Postorder;
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
        Tree whole=new Tree((0, len-1), (0, len-1));
        whole.printPreorder();
        sw.WriteLine(sb);
        sw.Flush();
    }
    public class Tree
    {
        private (int startIdx, int endIdx) _inorder;
        private (int startIdx, int endIdx) _postorder;
        private int _root;
        private Tree _left;
        private Tree _right;
        public Tree((int startIdx, int endIdx) inorder, (int startIdx, int endIdx) postorder)
        {
            _inorder=inorder;
            _postorder=postorder;
            _root=Postorder[postorder.endIdx];
            int idx=Array.IndexOf(Inorder,_root);
            int len=idx-inorder.startIdx;
            if(idx>inorder.startIdx)
            {
                _left=new Tree((inorder.startIdx, idx-1), (postorder.startIdx, postorder.startIdx+len-1));
            }
            if(postorder.startIdx+len<postorder.endIdx)
            {
                _right=new Tree((idx+1,inorder.endIdx),(postorder.startIdx+len,postorder.endIdx-1));
            }
        }
        public void printPreorder()
        {
            sb.Append(_root+" ");
            if(_left!=null)
            {
                _left.printPreorder();
            }
            if(_right!=null)
            {
                _right.printPreorder();
            }
        }
    }
}